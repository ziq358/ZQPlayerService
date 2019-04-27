package com.zq.zqplayer;

import lombok.Getter;


@Getter
public enum SystemStatusCode implements ErrorCode {
    OK(ErrorCode.OK, "success."),
    ERROR(ErrorCode.ERROR, "fail."),
    USER_NOT_LOGIN(ErrorCode.TOKEN_ERROR, "用户未登录，或登录过期"),
    // end
    ;
    private int code;
    private String message;

    SystemStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
