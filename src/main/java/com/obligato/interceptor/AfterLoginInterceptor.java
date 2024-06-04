package com.obligato.interceptor;


import com.obligato.util.LoginUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 로그인한 회원은 회원가입페이지와 로그인페이지에 접근을 차단
@Configuration
@Slf4j
public class AfterLoginInterceptor implements HandlerInterceptor { // 인터페이스 구현해야 함

}
