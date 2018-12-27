package com.zq.zqplayer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="zqconfig")
@lombok.Data
public class ZQConfig{
    private String author;
}