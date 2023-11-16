package com.ai.ai_work.service.Impl;

import com.ai.ai_work.entity.SecurityUser;
import com.ai.ai_work.entity.pojo.User;
import com.ai.ai_work.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
    private UserMapper userMapper;

    @Autowired
    public SecurityUserDetailsService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.selectByUsername(username);

        if(user == null){
            throw new RuntimeException("账号不存在");
        }

        return new SecurityUser(user);
    }
}
