package com.ai.ai_work.service.Impl;

import com.ai.ai_work.entity.dto.chat.DialogDto;
import com.ai.ai_work.mapper.ChatMapper;
import com.ai.ai_work.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public List<DialogDto> getInfo(Long userId) {
        return chatMapper.getInfo(userId);
    }
}
