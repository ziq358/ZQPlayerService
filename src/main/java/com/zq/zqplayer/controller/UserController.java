package com.zq.zqplayer.controller;

import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.ResultModelTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zq.zqplayer.model.User;
import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.model.request.UserRequestBean;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/getUserById", method = RequestMethod.GET)
    public ResultModel getUserById(@RequestParam(value = "id") int id){
        User user = userMapper.getUserById(id);
        Map<String, User> userMap = new HashMap<>();
        if (user != null) {
            userMap.put("user",user);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(1);
        resultModel.setData(userMap);
        return ResultModelTool.handleResultModel(resultModel);
    }
}
