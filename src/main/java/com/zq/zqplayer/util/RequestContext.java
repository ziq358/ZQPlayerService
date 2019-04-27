
package com.zq.zqplayer.util;

import com.zq.zqplayer.ServiceException;
import com.zq.zqplayer.SystemStatusCode;
import com.zq.zqplayer.common.Constant;
import com.zq.zqplayer.model.CurrentUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class RequestContext {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserInfoUtil  userInfoUtil;

    public CurrentUserInfo currentUserInfo() {
        String token = getToken();
        userInfoUtil.refreshSession(token);
        CurrentUserInfo currentUserInfo = userInfoUtil.redisGetUserInfo(token);
        if (currentUserInfo == null || StringUtils.isEmpty(currentUserInfo.getUserId())) {
            // TODO 未获取到用户信息，表示token无效或会话已失效
            throw new ServiceException(SystemStatusCode.USER_NOT_LOGIN);
        }
        return currentUserInfo;
    }

    private String getToken() {
        Cookie cookie = WebUtils.getCookie(request, Constant.TOKEN);
        if (cookie != null && !StringUtils.isEmpty(cookie.getValue())) {
            return cookie.getValue();
        }
        String token = request.getParameter(Constant.TOKEN);
        if (!StringUtils.isEmpty(token)) {
            return token;
        }
        token = request.getHeader(Constant.TOKEN);
        if (!StringUtils.isEmpty(token)) {
            return token;
        }
        // 未获取到token信息，表示用户未登录
        throw new ServiceException(SystemStatusCode.USER_NOT_LOGIN);
    }
}
