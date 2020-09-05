package com.zq.zqplayer.exception;

import lombok.Getter;

/**
 * @author : chenchengye
 * @date : 2018/7/10
 */
@Getter
public class ServiceException extends RuntimeException {
    private ErrorCode errCode;

    public ServiceException(ErrorCode errCode) {
        super();
        this.errCode = errCode;
    }
}
