package com.ai.ai_work.service;

import com.ai.ai_work.entity.pojo.ChatContent;
import com.ai.ai_work.entity.vo.chat.DialogVo;
import com.ai.ai_work.enums.Role;

import java.util.List;

public interface ChatService {

    List<DialogVo> getInfo(Long userId);

    void addDialog(Long uuid, String title, Long userId);

    void deleteDialog(Long uuid, Long userId);

    void updateDialog(Long userId, Long uuid, String title);

    List<ChatContent> getBotInfo(Long userId, Long uuid);

    void addContent(String question, Role role, Long uuid, Long userId);

}
