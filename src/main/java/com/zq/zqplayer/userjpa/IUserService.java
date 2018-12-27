package com.zq.zqplayer.userjpa;

import java.util.List;
import com.zq.zqplayer.model.User;

public interface IUserService {
/**
*
* @return 获取所有的用户
*/
List<User> getAllUser();
/**
*
* @param user
* @return 增
*/
int addUser(User user);
    //删
int  deleteUser(long id);
    //改
int updateUser(User User);
    //查
User queryUser(long id);
}