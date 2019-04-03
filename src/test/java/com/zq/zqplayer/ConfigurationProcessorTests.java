package com.zq.zqplayer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
