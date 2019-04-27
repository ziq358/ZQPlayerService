package com.zq.zqplayer.service;

import com.zq.zqplayer.model.UserInfo;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
public interface UserService {

    /**
    * @param userId 用户userId
    * @return 返回用户信息
    */
    UserInfo getUserByUserId(String userId);

    UserInfo getUserByName(String name);

    int insertUser(UserInfo user);

}
