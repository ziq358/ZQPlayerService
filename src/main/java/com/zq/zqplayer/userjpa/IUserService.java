package com.zq.zqplayer.userjpa;

import java.util.List;

public interface IUserService {
/**
*
* @return 获取所有的用户
*/
List<MyUser> getAllUser();
/**
*
* @param user
* @return 增
*/
int addUser(MyUser user);
    //删
int  deleteUser(long id);
    //改
int updateUser(MyUser User);
    //查
    MyUser queryUser(long id);
}