package com.zq.zqplayer.mapper;

import com.zq.zqplayer.userjpa.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getUserById(@Param("id") int id);
}