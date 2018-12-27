package com.zq.zqplayer.service;

import com.zq.zqplayer.model.User;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
public interface UserService {

    /**
    * @param id 用户id
    * @return 返回用户信息
    */
    User getUserById(int id);

}
