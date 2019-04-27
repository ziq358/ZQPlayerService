package com.zq.zqplayer.mapper;

import com.zq.zqplayer.model.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
public interface UserMapper {
    UserInfo getUserByUserId(@Param("userId") String userId);

    UserInfo getUserByName(@Param("name") String name);

    int insertUser(UserInfo user);
}