package com.zq.zqplayer;

import lombok.Getter;


@Getter
public enum SystemStatusCode implements ErrorCode {
    OK(ErrorCode.OK, "success."),
    ERROR(ErrorCode.ERROR, "fail."),
    // end
    ;
    private long code;
    private String message;

    SystemStatusCode(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
