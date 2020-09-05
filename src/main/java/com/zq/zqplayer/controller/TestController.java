package com.zq.zqplayer.controller;

import com.zq.zqplayer.exception.ErrorCode;
import com.zq.zqplayer.exception.ServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/hello")
    public String Hello(){
        return "hello world";
    }

    @RequestMapping("/err")
    public String err(){
        throw new ServiceException(new ErrorCode() {
            @Override
            public int getCode() {
                return -1;
            }

            @Override
            public String getMessage() {
                return "错误测试";
            }
        });
    }
}
