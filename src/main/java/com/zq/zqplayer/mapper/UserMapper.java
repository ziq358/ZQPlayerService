package com.zq.zqplayer.mapper;

import com.zq.zqplayer.model.user.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user")
    List<UserInfo> getAll();
}
