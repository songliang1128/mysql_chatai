package com.ai.ai_work.mapper;

import com.ai.ai_work.entity.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper extends BaseMapper<User> {


    @Select("select *from user where username = #{username}")
    public User selectByUsername(String username);
}
