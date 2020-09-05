package com.zq.zqplayer.schedule;

import com.zq.zqplayer.mapper.LiveMapper;
import com.zq.zqplayer.model.live.RoomInfo;
import com.zq.zqplayer.util.PythonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.List;

@EnableScheduling
@Configuration
public class LivePythonTask {

    @Autowired
    LiveMapper liveMapper;

    //3.添加定时任务
    @Scheduled(cron = "0 0/10 * * * ?")//每10分钟
    private void liveTask() {
        System.err.println("执行liveTask时间: " + LocalDateTime.now());
        liveMapper.clean();
        List<RoomInfo> result = PythonUtil.execDouYuPython(0, 20);
        for (RoomInfo room: result) {
            liveMapper.insert(room);
        }
    }
}
