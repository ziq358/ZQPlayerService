package com.zq.zqplayer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.zq.zqplayer.config.ZQConfig;

@SpringBootApplication
@MapperScan("com.zq.zqplayer.mapper")//for mybatis
//@EnableConfigurationProperties({ZQConfig.class})
// 自定义配置  也可以直接在ZQConfig中加@Component 注解
public class ZqplayerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZqplayerApplication.class, args);
    }

}
