package com.ai.ai_work.filter;


import com.ai.ai_work.entity.SecurityUser;
import com.ai.ai_work.entity.pojo.User;
import com.ai.ai_work.mapper.UserMapper;
import com.ai.ai_work.service.Impl.SecurityUserDetailsService;
import com.ai.ai_work.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    @Autowired
    UserMapper userMapper;


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwtToken = authorization.substring(7);

        try {
            JwtUtil.verify(jwtToken);
        } catch (Exception e) {
            log.info("token报错");
            return;
        }

        try {
            String username = JwtUtil.decode(jwtToken, "username");

            if (!username.trim().isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = userMapper.selectByUsername(username);

                SecurityUser securityUser = new SecurityUser(user);

                UsernamePasswordAuthenticationToken authenticationToken = new
                        UsernamePasswordAuthenticationToken(securityUser,null, null);

                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }catch (UsernameNotFoundException e){
            log.info("账号没找到");
            return;
        }
        filterChain.doFilter(request, response);
    }
}
