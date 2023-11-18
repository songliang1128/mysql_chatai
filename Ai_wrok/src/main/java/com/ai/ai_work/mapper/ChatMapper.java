package com.ai.ai_work.mapper;

import com.ai.ai_work.entity.pojo.ChatContent;
import com.ai.ai_work.entity.vo.chat.DialogVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper extends BaseMapper<ChatContent> {

    public List<DialogVo> getInfo(Long userId);

    void addDialog(Long uuid, String title, Long userId);

    void delete(Long uuid, Long userId);

    void updateDialog(Long userId, Long uuid, String title);

    void deleteContent(Long uuid, Long userId);

    void addContent(ChatContent chatContent);
}
