package com.obligato.util;

import com.obligato.mvc.dto.response.LoginUserInfoDto;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUtil {

    public static final String LOGIN = "login";
    public static final String AUTO_LOGIN_COOKIE = "auto";

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute(LOGIN) != null;
    }

    public static String getLoggedInUserAccount(HttpSession session) {
        LoginUserInfoDto currentUser = (LoginUserInfoDto) session.getAttribute(LOGIN);
        return (currentUser != null) ? currentUser.getAccount() : null;
    }

    public static boolean isAutoLogin(HttpServletRequest request ) {
        Cookie autoLoginCookie = WebUtils.getCookie(request, AUTO_LOGIN_COOKIE);
        return autoLoginCookie != null;
    }
}
