package com.obligato.mvc.service;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.UserSignUpDto;
import com.obligato.mvc.dto.response.LoginUserInfoDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.obligato.mvc.service.LoginResult.*;
import static com.obligato.util.LoginUtil.LOGIN;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserMapper mapper;
    private final PasswordEncoder encoder;

    // 회원가입 중간 처리
    public boolean signUp(UserSignUpDto dto) {
        User user = dto.toEntity();
       return mapper.save(user);
    }

    // 로그인 검증 처리
    public LoginResult authenticate(LoginDto dto, HttpSession session) {

        // 회원가입 여부 확인
        String account = dto.getUsername();
        User foundMember = mapper.findOne(account);

        if (foundMember == null) {
            log.info("{} - 회원가입이 필요합니다.", account);
            return NO_ACC;
        }

        // 비밀번호 일치 검사
        String inputPassword = dto.getPassword(); // 클라이언트에 입력한 비번
        String originPassword = foundMember.getPassword(); // 데이터베이스에 저장된 비번

        // PasswordEncoder에서는 암호화된 비번을 내부적으로 비교해주는 기능을 제공
        if (!encoder.matches(inputPassword, originPassword)) {
            log.info("비밀번호가 일치하지 않습니다.");
            return NO_PW;
        }

        log.info("{}님 로그인 성공", foundMember.getName());

        // 세션의 수명 : 설정된 시간 OR 브라우저를 닫기 전까지
        int maxInactiveInterval = session.getMaxInactiveInterval();
        // 세션의 기본 수명은 30분, setter로 수명 설정 가능
        session.setMaxInactiveInterval(60 * 60); // 세션 수명 1시간 설정
        log.debug("session time: {}", maxInactiveInterval); // 3600

        session.setAttribute(LOGIN, new LoginUserInfoDto(foundMember)); // 핵심코드

        return SUCCESS;
    }




}
