package com.zq.zqplayer.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserLoginRequest {

    @NotBlank(message = "userName不能为空")
    private String userName;
    @NotBlank(message = "password不能为空")
    private String password;
}
