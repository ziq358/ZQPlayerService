package com.zq.zqplayer.mapper;

import com.zq.zqplayer.model.live.RoomInfo;
import com.zq.zqplayer.model.user.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface LiveMapper {

    @Select("SELECT * FROM room")
    @Results({
            @Result(property = "room_id",  column = "room_id"),
            @Result(property = "room_src",  column = "room_src"),
            @Result(property = "room_name",  column = "room_name"),
            @Result(property = "nickname",  column = "nickname"),
            @Result(property = "live_url", column = "live_url")
    })
    List<RoomInfo> getAll();

    @Insert({ "insert into room(room_id, room_src, room_name, nickname, live_url) values(#{room_id}, #{room_src}, #{room_name}, #{nickname}, #{live_url})" })
    void insert(RoomInfo roomInfo);

    @Update("truncate table room")
    void clean();
}
