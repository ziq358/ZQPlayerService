package com.zq.zqplayer.service.impl;

import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.service.UserService;
import com.zq.zqplayer.userjpa.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
