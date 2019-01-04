package com.zq.zqplayer;

import com.zq.zqplayer.userjpa.IUserService;
import com.zq.zqplayer.userjpa.MyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTests {

    @Autowired
    IUserService userService;

    @Test
    public void getAllUser() {
        List<MyUser> userList = userService.getAllUser();
        for (MyUser user :
                userList) {
            System.out.println(user.toString());
        }
    }
}
