package com.obligato.mvc.interceptor;

import com.obligato.mvc.entity.User;
import com.obligato.mvc.mapper.UserMapper;
import com.obligato.mvc.service.UserService;
import com.obligato.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class AutoLoginInterCeptor implements HandlerInterceptor {

    private final UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie autoLoginCookie
                = WebUtils.getCookie(request, LoginUtil.AUTO_LOGIN_COOKIE);

        if (autoLoginCookie != null
            && !LoginUtil.isLoggedIn(request.getSession())) {
            String sessionId = autoLoginCookie.getValue();
            User foundMember = userMapper.findBySessionId(sessionId);
            if (foundMember != null
                && LocalDateTime.now().isBefore(foundMember.getLimitTime())) {
                UserService.maintainLoginState(request.getSession(), foundMember);
            }
        }
        return true;

    }
}
