package com.zq.zqplayer.controller;

import com.zq.zqplayer.mapper.LiveMapper;
import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.model.ResultModel;
import com.zq.zqplayer.model.live.RoomInfo;
import com.zq.zqplayer.util.PythonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@lombok.extern.slf4j.Slf4j
@RestController
@RequestMapping(value = "/live")
public class LiveController {

    @Autowired
    private LiveMapper liveMapper;

    @RequestMapping("/all")
    public ResultModel all(){
        ResultModel resultModel = new ResultModel();
        List<RoomInfo> result = liveMapper.getAll();
        resultModel.setData(result);
        return resultModel;
    }
}
