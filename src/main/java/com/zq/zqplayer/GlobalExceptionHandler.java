package com.zq.zqplayer;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j //如果不想每次都写private  final Logger logger = LoggerFactory.getLogger(XXX.class); 可以用注解@Slf4j
@ControllerAdvice //这个注解将这个类作为全局异常处理类
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class) //注解里面是自定义异常类，当抛出这个异常时，这个方法就会处理异常
    @ResponseBody
    @ResponseStatus(HttpStatus.OK) //注解代表返回给前端的状态码
    public ErrResp handleException(HttpServletRequest request, Throwable cause) {
        ErrResp errResp = new ErrResp(request.getRequestURI());
        handleMethodArgumentNotValidException(errResp, cause);
        handleHttpMessageNotReadableException(errResp, cause);
        if (errResp.getCode() == 0) {
            errResp.initCode(119, cause.getMessage());
        }
        log.info("errResp={}", errResp, cause);
        return errResp;
    }

    //参数错误
    private void handleMethodArgumentNotValidException(ErrResp errResp, Throwable cause) {
        if (cause instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException e = (MethodArgumentNotValidException) cause;
            List<ObjectError> errors = e.getBindingResult().getAllErrors();
            List<String> messages = new ArrayList<>(errors.size());
            errors.forEach(objectError -> messages.add(objectError.getDefaultMessage()));
            errResp.initCode(125, "params error: " + messages.toString());
        }
    }

    //不可读异常
    private void handleHttpMessageNotReadableException(ErrResp errResp, Throwable cause) {
        if (cause instanceof HttpMessageNotReadableException) {
            errResp.initCode(125, "read request message failed.");
        }
    }

    @Data
    private class ErrResp {
        private long code;
        private String message;
        private String url;
        private long timestamp = System.currentTimeMillis();

        private ErrResp(String url) {
            this.url = url;
        }

        private void initCode(ErrorCode errCode) {
            this.code = errCode.getCode();
            this.message = errCode.getMessage();
        }

        private void initCode(long code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
