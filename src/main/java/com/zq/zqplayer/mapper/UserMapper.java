package com.zq.zqplayer.mapper;

import com.zq.zqplayer.model.User;
import org.apache.ibatis.annotations.Param;

/**
*
* @author zaiqiang
* @since 2018/12/25
*/
public interface UserMapper {
    /**
    *
    * @param id 用户id
    * @return 用户信息
    */
    User getUserById(@Param("id") int id);

}