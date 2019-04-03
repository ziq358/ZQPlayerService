package com.zq.zqplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.zq.zqplayer.filter")//for filter指定扫描的包
@MapperScan("com.zq.zqplayer.mapper")//for mybatis
//@EnableConfigurationProperties({ZQConfig.class})// 自定义配置  也可以直接在ZQConfig中加@Component 注解
public class ZqplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqplayerApplication.class, args);
    }

}
