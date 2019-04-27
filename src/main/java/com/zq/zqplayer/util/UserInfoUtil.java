package com.zq.zqplayer.util;

import com.zq.zqplayer.common.Constant;
import com.zq.zqplayer.model.CurrentUserInfo;
import com.zq.zqplayer.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class UserInfoUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    public void redisSaveUserInfo(String userId) {
        CurrentUserInfo currentUserInfo = new CurrentUserInfo();
        currentUserInfo.setUserId(userId);
        String sessionKey = Constant.SESSION+"::"+userId;
        Long expireTime = Long.valueOf(10);
        redisTemplate.opsForValue().set(sessionKey, currentUserInfo, expireTime, TimeUnit.MINUTES);
    }

    public String refreshSession(String token) {
        String sessionKey = Constant.SESSION+"::"+token;
        if (redisTemplate.hasKey(sessionKey)) {
            Long expireTime = Long.valueOf(10);
            redisTemplate.expire(sessionKey, expireTime, TimeUnit.MINUTES);
        }
        return "reset expire on " + System.currentTimeMillis();
    }

    public CurrentUserInfo redisGetUserInfo(String token) {
        String sessionKey = Constant.SESSION+"::"+token;
        CurrentUserInfo user = (CurrentUserInfo) redisTemplate.opsForValue().get(sessionKey);
        return user;
    }
}
