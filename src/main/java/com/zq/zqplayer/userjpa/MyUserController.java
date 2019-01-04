package com.zq.zqplayer.userjpa;

import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.ResultModelTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/myuser")
public class MyUserController {


    @Autowired
    IUserService userService;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResultModel getAllUser(){
        List<MyUser> userList = userService.getAllUser();
        Map<String,List<MyUser>> userMap = new HashMap<>();
        if (userList != null) {
            userMap.put("users",userList);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setData(userMap);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/addUser")
    public ResultModel addUser(@RequestParam long id, @RequestParam String name, @RequestParam String age){
        MyUser user = new MyUser(id,name,age);
        int errorCode = userService.addUser(user);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(user);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @PostMapping(value = "/updateUser")
    public ResultModel updateUser(@RequestParam long id, @RequestParam String name, @RequestParam String age){
        MyUser user = new MyUser(id,name,age);
        int errorCode = userService.updateUser(user);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        resultModel.setData(user);
        return ResultModelTool.handleResultModel(resultModel);
    }

    @GetMapping(value = "/deleteUser/{id}")
    public ResultModel deleteUser(@PathVariable long id){
        int errorCode = userService.deleteUser(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errorCode);
        List<MyUser> userList = userService.getAllUser();
        Map<String,List<MyUser>> usermap = new HashMap<>();
        if (userList != null) {
            usermap.put("users",userList);
        }
        resultModel.setData(usermap);
        return ResultModelTool.handleResultModel(resultModel);
    }
}
