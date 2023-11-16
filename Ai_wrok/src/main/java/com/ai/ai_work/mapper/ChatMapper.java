package com.ai.ai_work.mapper;

import com.ai.ai_work.entity.dto.chat.DialogDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChatMapper {

    public List<DialogDto> getInfo(Long userId);
}
