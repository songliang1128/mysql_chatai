package com.ai.ai_work.service.Impl;

import com.ai.ai_work.entity.pojo.ChatContent;
import com.ai.ai_work.entity.vo.chat.DialogVo;
import com.ai.ai_work.enums.Role;
import com.ai.ai_work.mapper.ChatMapper;
import com.ai.ai_work.service.ChatService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ChatServiceImpl extends ServiceImpl<ChatMapper, ChatContent> implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<DialogVo> getInfo(Long userId) {
        return chatMapper.getInfo(userId);
    }

    @Override
    public void addDialog(Long uuid, String title, Long userId) {
        chatMapper.addDialog(uuid, title, userId);
    }

    @Override
    public void deleteDialog(Long uuid, Long userId) {
        chatMapper.delete(uuid, userId);
        chatMapper.deleteContent(uuid, userId);
    }

    @Override
    public void updateDialog(Long userId, Long uuid, String title) {
        chatMapper.updateDialog(userId, uuid, title);
    }

    @Override
    public List<ChatContent> getBotInfo(Long userId, Long uuid) {

        QueryWrapper<ChatContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("uuid", uuid);

        return this.list(queryWrapper);
    }

    @Override
    public void addContent(String question, Role role, Long uuid, Long userId) {
        ChatContent chatContent = null;
        if(role == Role.USER) {
            chatContent = ChatContent.builder()
                    .content(question)
                    .role("user")
                    .userId(userId)
                    .uuid(uuid)
                    .time(LocalDateTime.now())
                    .build();
        } else if(role == Role.ASSISTANT){
            chatContent = ChatContent.builder()
                    .content(question)
                    .role("assistant")
                    .userId(userId)
                    .uuid(uuid)
                    .time(LocalDateTime.now())
                    .build();
        }
        chatMapper.addContent(chatContent);
    }


}
