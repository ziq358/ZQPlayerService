package com.zq.zqplayer;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResultModel implements Serializable {
    private int code;
    private String msg;
    private String url;
    private long timestamp = System.currentTimeMillis();
    private Object data ;
}