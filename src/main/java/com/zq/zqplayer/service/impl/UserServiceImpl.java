package com.zq.zqplayer.service.impl;

import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.model.request.UserRegisterRequest;
import com.zq.zqplayer.service.UserService;
import com.zq.zqplayer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int insertUser(UserRegisterRequest request) {
        return userMapper.insertUser(request);
    }
}
