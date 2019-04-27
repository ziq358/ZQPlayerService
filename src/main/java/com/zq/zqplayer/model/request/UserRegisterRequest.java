package com.zq.zqplayer.model.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterRequest {
    @NotBlank(message = "username不能为空")
    @JsonProperty("username")
    private String userName;
    @NotBlank(message = "password不能为空")
    @JsonProperty("password")
    private String password;
}
