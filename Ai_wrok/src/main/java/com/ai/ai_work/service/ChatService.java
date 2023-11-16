package com.ai.ai_work.service;

import com.ai.ai_work.entity.dto.chat.DialogDto;

import java.util.List;

public interface ChatService {

    public List<DialogDto> getInfo(Long userId);
}
