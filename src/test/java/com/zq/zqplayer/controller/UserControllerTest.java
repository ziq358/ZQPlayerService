package com.zq.zqplayer.controller;

import com.alibaba.fastjson.JSONObject;
import com.zq.zqplayer.ErrorCode;
import com.zq.zqplayer.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserService userService;

    private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @Before // 在测试开始前初始化工作
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getUserByUserId() throws Exception {
        MvcResult result = mockMvc.perform(get("/user/getUserByUserId").param("userId", "123"))
                .andExpect(status().isOk())// 模拟向testRest发送get请求
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    public void login() throws Exception {
        JSONObject request = new JSONObject();
        request.put("username", "ziq358");
        request.put("password", "123456");

        MvcResult result = mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON).content(JSONObject.toJSONString(request)))
                .andExpect(status().isOk())// 期望值 是200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
        JSONObject jsonObject = JSONObject.parseObject(result.getResponse().getContentAsString());
        Assert.assertEquals(String.valueOf(ErrorCode.OK), jsonObject.getString("code"));
    }

    @Test
    public void register() throws Exception{
        Date date = new Date();
        JSONObject request = new JSONObject();
        request.put("username", "zaiqiang"+date.getTime());
        request.put("password", "wuyanqiang");

        String content = JSONObject.toJSONString(request);
        MvcResult result = mockMvc.perform(post("/user/register").contentType(MediaType.APPLICATION_JSON).content(content))
                .andExpect(status().isOk())// 期望值 是200 OK
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8
                .andReturn();// 返回执行请求的结果
        System.out.println(result.getResponse().getContentAsString());
        JSONObject jsonObject = JSONObject.parseObject(result.getResponse().getContentAsString());
        Assert.assertEquals(String.valueOf(ErrorCode.OK), jsonObject.getString("code"));
    }
}