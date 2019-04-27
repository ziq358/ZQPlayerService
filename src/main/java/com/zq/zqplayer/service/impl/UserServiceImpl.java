package com.zq.zqplayer.service.impl;

import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.model.UserInfo;
import com.zq.zqplayer.service.UserService;
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
    public UserInfo getUserByUserId(String userId) {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public UserInfo getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int insertUser(UserInfo user) {
        return userMapper.insertUser(user);
    }
}
