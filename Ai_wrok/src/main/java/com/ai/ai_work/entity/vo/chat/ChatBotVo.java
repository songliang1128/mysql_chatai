package com.ai.ai_work.entity.vo.chat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatBotVo {

    private String role;

    private LocalDateTime time;

    private String content;
}
