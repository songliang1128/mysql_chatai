package com.ai.ai_work.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uuid {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long uuid;

    private String title;
}
