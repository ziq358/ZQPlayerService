package com.zq.zqplayer.controller;

import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/all")
    public ResultModel all(){
        ResultModel resultModel = new ResultModel();
        resultModel.setData(userMapper.getAll());
        return resultModel;
    }
}
