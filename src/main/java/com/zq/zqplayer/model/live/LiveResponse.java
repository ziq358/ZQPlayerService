package com.zq.zqplayer.model.live;

import lombok.Data;

import java.util.List;

@Data
public class LiveResponse<T> {
    private String status;
    private String msg;
    private T result;
}