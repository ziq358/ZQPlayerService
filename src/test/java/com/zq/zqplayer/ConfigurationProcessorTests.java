package com.zq.zqplayer;

import com.zq.zqplayer.mapper.UserMapper;
import com.zq.zqplayer.userjpa.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hibernate.engine.jdbc.ReaderInputStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import com.zq.zqplayer.config.ZQConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationProcessorTests {

    @Autowired
    private ZQConfig zqConfig;

    @Test
    public void configTest() {
        System.out.println(zqConfig.getAuthor());
    }

}
