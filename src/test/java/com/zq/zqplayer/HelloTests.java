package com.zq.zqplayer;

import com.zq.zqplayer.controller.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class HelloTests {

    @Autowired
    TestController testController;

    @Test
    public void hello() {
        System.out.println(testController.Hello());

    }
}
