package com.ai.ai_work.service.Impl;

import com.ai.ai_work.mapper.UserMapper;
import com.ai.ai_work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
}
