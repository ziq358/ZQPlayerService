package com.zq.zqplayer;

import com.zq.zqplayer.controller.TestController;
import com.zq.zqplayer.mapper.LiveMapper;
import com.zq.zqplayer.model.live.RoomInfo;
import com.zq.zqplayer.util.PythonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class HelloTests {

    @Autowired
    TestController testController;
    @Autowired
    LiveMapper liveMapper;

    @Test
    public void hello() {
        System.out.println(testController.Hello());
    }

    @Test
    public void python() {
        System.out.println("python start");
        List<RoomInfo> result = PythonUtil.execDouYuPython(0, 5);
        for (RoomInfo room:result) {
            liveMapper.insert(room);
        }
        System.out.println("python end");
        System.out.println(result);
    }

    @Test
    public void clean() {
        liveMapper.clean();
    }

    @Test
    public void roomAll() {
        List<RoomInfo> result = liveMapper.getAll();
        System.out.println(result);
    }
}
