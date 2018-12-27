package com.zq.zqplayer.service.impl;

import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.service.UserService;
import com.zq.zqplayer.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }
}
