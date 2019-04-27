package com.zq.zqplayer.controller;

import com.zq.zqplayer.ErrorCode;
import com.zq.zqplayer.ResultModel;
import com.zq.zqplayer.model.UserInfo;
import com.zq.zqplayer.model.request.UserLoginRequest;
import com.zq.zqplayer.model.request.UserRegisterRequest;
import com.zq.zqplayer.service.UserService;
import com.zq.zqplayer.util.UUIDUtil;
import com.zq.zqplayer.util.UserInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {


    @Autowired
    UserService userService;
    @Autowired
    UserInfoUtil userInfoUtil;


    @PostMapping(value = "/login")
    public ResultModel login(@RequestBody @Valid UserLoginRequest request){
        ResultModel resultModel = new ResultModel();
        UserInfo user = userService.getUserByName(request.getUserName());
        if(user != null){
            if(user.getPassword().equals(request.getPassword())){
                user.setToken(user.getUserId());
                resultModel.setCode(ErrorCode.OK);
                resultModel.setMsg("登陆成功！");
                resultModel.setData(user);
                userInfoUtil.redisSaveUserInfo(user.getUserId());
            }else {
                resultModel.setCode(ErrorCode.ERROR);
                resultModel.setMsg("密码错误！");
            }

        }else{
            resultModel.setCode(ErrorCode.ERROR);
            resultModel.setMsg("用户不存在，请注册！");
        }
        return resultModel;
    }

    @PostMapping(value = "/register")
    public ResultModel register(@RequestBody @Valid UserRegisterRequest request){
        ResultModel resultModel = new ResultModel();
        UserInfo user = userService.getUserByName(request.getUserName());
        if(user != null){
            resultModel.setCode(ErrorCode.ERROR);
            resultModel.setMsg("用户已存在，请登陆！");
        }else{
            user = new UserInfo();
            user.setUserId(UUIDUtil.getUUID());
            user.setUserName(request.getUserName());
            user.setPassword(request.getPassword());
            int result = userService.insertUser(user);
            if(result > 0){
                user = userService.getUserByName(request.getUserName());
                user.setToken(user.getUserId());
                resultModel.setCode(ErrorCode.OK);
                resultModel.setMsg("注册成功！");
                resultModel.setData(user);
                userInfoUtil.redisSaveUserInfo(user.getUserId());
            }else{
                resultModel.setCode(ErrorCode.ERROR);
                resultModel.setMsg("注册失败！");
            }
        }
        return resultModel;
    }


    @RequestMapping(value = "/getUserByUserId", method = RequestMethod.GET)
    public ResultModel getUserByUserId(@RequestParam(value = "userId") String userId){
        UserInfo user = userService.getUserByUserId(userId);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(1);
        resultModel.setData(user);
        return resultModel;
    }



}
