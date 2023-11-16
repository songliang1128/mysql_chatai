package com.ai.ai_work.service;

import com.ai.ai_work.entity.pojo.ChatContent;
import com.ai.ai_work.entity.vo.chat.DialogVo;

import java.util.List;

public interface ChatService {

    public List<DialogVo> getInfo(Long userId);

    void addDialog(Long uuid, String title, Long userId);

    void deleteDialog(Long uuid, Long userId);

    void updateDialog(Long userId, Long uuid, String title);

    List<ChatContent> getBotInfo(String username, Long uuid);

}
