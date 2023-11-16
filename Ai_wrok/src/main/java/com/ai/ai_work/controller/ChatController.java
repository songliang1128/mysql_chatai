package com.ai.ai_work.controller;

import com.ai.ai_work.entity.SecurityUser;
import com.ai.ai_work.entity.dto.chat.DialogDto;
import com.ai.ai_work.entity.pojo.User;
import com.ai.ai_work.service.ChatService;
import com.ai.ai_work.utils.resonse.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat/get-list")
    private Result<List<DialogDto>> getInfo(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        User user = securityUser.getUser();

        Long userId = user.getId();

        return Result.success(chatService.getInfo(userId));
    }
}
