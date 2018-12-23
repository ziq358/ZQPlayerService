package com.zq.zqplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zq.zqplayer.mapper")
public class ZqplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqplayerApplication.class, args);
    }
}
