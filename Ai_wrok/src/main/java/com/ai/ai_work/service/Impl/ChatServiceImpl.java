package com.ai.ai_work.service.Impl;

import com.ai.ai_work.entity.pojo.ChatContent;
import com.ai.ai_work.entity.vo.chat.DialogVo;
import com.ai.ai_work.mapper.ChatMapper;
import com.ai.ai_work.service.ChatService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    }

    @Override
    public void updateDialog(Long userId, Long uuid, String title) {
        chatMapper.updateDialog(userId, uuid, title);
    }

    @Override
    public List<ChatContent> getBotInfo(String username, Long uuid) {
        QueryWrapper<ChatContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("uuid", uuid);
        return this.list(queryWrapper);
    }


}
