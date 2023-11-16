package com.ai.ai_work.controller;

import com.ai.ai_work.entity.SecurityUser;
import com.ai.ai_work.entity.pojo.ChatContent;
import com.ai.ai_work.entity.vo.chat.ChatBotVo;
import com.ai.ai_work.entity.vo.chat.DialogVo;
import com.ai.ai_work.entity.pojo.User;
import com.ai.ai_work.mapper.ChatMapper;
import com.ai.ai_work.service.ChatService;
import com.ai.ai_work.utils.resonse.Result;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/chat/get-list")
    public Result<List<DialogVo>> getInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        User user = securityUser.getUser();

        Long userId = user.getId();

        return Result.success(chatService.getInfo(userId));
    }

    @PostMapping("/chat")
    public Result addDialog(@RequestBody Map<String, String> map){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        User user = securityUser.getUser();

        Long uuid = Long.valueOf(map.get("uuid"));

        String title = map.get("title");

        Long userId = user.getId();

        chatService.addDialog(uuid, title, userId);

        return Result.success();
    }

    @GetMapping ("/chat/delete/{uuid}")
    public Result deleteDialog(@PathVariable Long uuid){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        User user = securityUser.getUser();
        Long userId = user.getId();

        chatService.deleteDialog(uuid, userId);

        return Result.success();
    }

    @PostMapping("/chat/change")
    public Result changeDia(@RequestBody Map<String, String> map){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

        User user = securityUser.getUser();

        Long uuid = Long.valueOf(map.get("uuid"));

        String title = map.get("title");

        Long userId = user.getId();

        chatService.updateDialog(userId, uuid, title);
        return Result.success();
    }

    @GetMapping("/chat/getInfo")
    public Result<List<ChatBotVo>> getBotInfo(@RequestParam Map<String, String> map){

        String username = map.get("username");
        String uuid = map.get("uuid");

        List<ChatContent> chatContents = chatService.getBotInfo(username, Long.valueOf(uuid));

        List<ChatBotVo> chatBotVos = new ArrayList<>();
        BeanUtils.copyProperties(chatContents, chatBotVos);

        return Result.success(chatBotVos);
    }


}
