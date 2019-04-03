package com.zq.zqplayer;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="zqconfig")
@lombok.Data
public class ZQConfig{
    private String author;
}