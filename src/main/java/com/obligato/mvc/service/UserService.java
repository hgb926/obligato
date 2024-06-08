package com.obligato.mvc.service;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.SignUpDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
    public LoginResult authenticate(LoginDto dto, HttpSession session) {

        // 회원가입 여부 확인
        User foundMember = userMapper.findOne(dto.getUsername());
        if (foundMember == null) {
            log.info("User not found", dto.getUsername());
            return NO_ACC;
        }
        // 비밀번호 일치 검사
        if (dto.getPassword().equals(foundMember.getPassword())) {
            session.setAttribute("user", foundMember);
            return SUCCESS;
        } else {
            log.info("비밀번호 불일치");
            return NO_PW;
        }

    }


//    public LoginDto convertToUser(SignUpDto dto) {
//        // db에 조회해서 가져온다.
//        LoginDto loginDto = LoginDto.builder()
//                .username(dto.getUsername())
//                .password(dto.getPassword())
//                .build();
//    }
}
