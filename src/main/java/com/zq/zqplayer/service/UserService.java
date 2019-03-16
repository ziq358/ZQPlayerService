package com.zq.zqplayer.service;

import com.zq.zqplayer.model.User;
import com.zq.zqplayer.model.request.UserRegisterRequest;

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
    User getUserByUserId(String userId);

    User getUserByName(String name);

    int insertUser(UserRegisterRequest request);

}
