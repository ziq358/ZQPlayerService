package com.zq.zqplayer.user;

import java.util.List;

public interface IUserService {
    //获取所有的用户
    List<User> getAllUser();
    //增
    int  addUser(User user);
    //删
    int  deleteUser(long id);
    //改
    int updateUser(User User);
    //查
    User queryUser(long id);
}