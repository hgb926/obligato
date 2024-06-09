package com.obligato.mvc.service;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.SignUpDto;
import com.obligato.mvc.dto.response.AutoLoginDto;
import com.obligato.mvc.dto.response.LoginUserInfoDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.mapper.UserMapper;
import com.obligato.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;

import static com.obligato.mvc.service.LoginResult.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder encoder;

    // 회원 가입 중간 처리
    public boolean join(SignUpDto dto) {

        User user = dto.toEntity();

//        user.setPassword(encoder.encode(user.getPassword()));

        return userMapper.save(user);
    }

    // 로그인 검증 처리
    public LoginResult authenticate(LoginDto dto, HttpSession session, HttpServletResponse response) {

        // 회원가입 여부 확인
        User foundMember = userMapper.findOne(dto.getUsername());
        if (foundMember == null) {
            log.info("User not found", dto.getUsername());
            return NO_ACC;
        }
        // 비밀번호 일치 검사
        if (dto.getPassword().equals(foundMember.getPassword())) {

            session.setAttribute("user", foundMember);

            if (dto.isAutoLogin()) {
                log.debug("AUTO LOGIN CHECK!");
                String sessionId = session.getId();
                Cookie autoLoginCookie = new Cookie(LoginUtil.AUTO_LOGIN_COOKIE, sessionId);
                autoLoginCookie.setPath("/");
                autoLoginCookie.setMaxAge(60*60*24*90);
                response.addCookie(autoLoginCookie);

                userMapper.updateAutoLogin(
                        AutoLoginDto.builder()
                                .sessionId(sessionId)
                                .limitTime(LocalDateTime.now().plusDays(90))
                                .account(dto.getUsername())
                                .build()
                );
            }

            return SUCCESS;
        } else {
            log.info("비밀번호 불일치");
            return NO_PW;
        }

    }

    public static void maintainLoginState(HttpSession session, User foundUser) {
        log.info("{}님 로그인 성공", foundUser.getUserName());
        int maxInactiveInterval = session.getMaxInactiveInterval();
        session.setMaxInactiveInterval(60 * 60);
        log.debug("session time: {}", maxInactiveInterval);
        session.setAttribute(LoginUtil.LOGIN, new LoginUserInfoDto(foundUser));
    }

}
