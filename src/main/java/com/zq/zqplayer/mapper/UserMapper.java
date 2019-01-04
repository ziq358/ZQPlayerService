package com.zq.zqplayer.mapper;

import com.zq.zqplayer.model.User;
import com.zq.zqplayer.model.request.UserRegisterRequest;
import org.apache.ibatis.annotations.Param;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
public interface UserMapper {
    /**
    *
    * @param userId 用户id
    * @return 用户信息
    */
    User getUserByUserId(@Param("userId") int userId);

    User getUserByName(@Param("name") String name);

    int insertUser(UserRegisterRequest request);

}