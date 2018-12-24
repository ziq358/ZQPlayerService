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
import java.io.InputStreamReader;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTests {

    @Test
    public void mybatisTest() {
        String resource = "mybatis/config.xml";

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                sb.append(line);
            }
            System.out.println(sb.toString());
            System.out.println("\nDone!");


            InputStream configinputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configinputStream);
            SqlSession session = sqlSessionFactory.openSession();
            try {
                User user = (User) session.selectOne("mybatis.UserMapper.getUserById", 1);
                System.out.println(user.getName());
            } finally {
                session.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Autowired
    private UserMapper userMapper;
    @Test
    public void mybatisStarterText() {
        User user = userMapper.getUserById(1);
        System.out.println(String.format("mybatisStarterText :: %s", user.getName()));
    }

}
