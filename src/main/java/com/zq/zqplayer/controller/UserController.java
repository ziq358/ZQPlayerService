package com.zq.zqplayer.controller;

import com.zq.zqplayer.ErrorCode;
import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.ResultModelTool;
import com.zq.zqplayer.model.User;
import com.zq.zqplayer.model.request.UserLoginRequest;
import com.zq.zqplayer.model.request.UserRegisterRequest;
import com.zq.zqplayer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.GET)
    public ResultModel getUserByUserId(@RequestParam(value = "userId") int userId){
        User user = userService.getUserByUserId(userId);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(1);
        resultModel.setData(user);
        return resultModel;
    }

    @PostMapping(value = "/login")
    public ResultModel login(@RequestBody UserLoginRequest request){
        ResultModel resultModel = new ResultModel();
        User user = userService.getUserByName(request.getUserName());
        if(user != null){
            if(user.getPassword().equals(request.getPassword())){
                resultModel.setCode(ErrorCode.OPERATION_OK);
                resultModel.setMsg("登陆成功！");
                resultModel.setData(user);
            }else {
                resultModel.setCode(ErrorCode.OPERATION_ERROR);
                resultModel.setMsg("密码错误！");
            }

        }else{
            resultModel.setCode(ErrorCode.OPERATION_ERROR);
            resultModel.setMsg("用户不存在，请注册！");
        }
        return resultModel;
    }

    @PostMapping(value = "/register")
    public ResultModel register(@RequestBody UserRegisterRequest request){
        ResultModel resultModel = new ResultModel();
        User user = userService.getUserByName(request.getUserName());
        if(user != null){
            resultModel.setCode(ErrorCode.OPERATION_ERROR);
            resultModel.setMsg("用户已存在，请登陆！");
        }else{
            int result = userService.insertUser(request);
            if(result > 0){
                user = userService.getUserByName(request.getUserName());
                resultModel.setCode(ErrorCode.OPERATION_OK);
                resultModel.setMsg("注册成功！");
                resultModel.setData(user);
            }else{
                resultModel.setCode(ErrorCode.OPERATION_ERROR);
                resultModel.setMsg("注册失败！");
            }

        }
        return resultModel;
    }

}
