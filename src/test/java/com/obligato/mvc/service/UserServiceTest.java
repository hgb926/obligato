package com.obligato.mvc.service;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.SignUpDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    @DisplayName("회원가입 시 비밀번호 인코딩")
    void joinTest() {
        //given
        SignUpDto dto = SignUpDto.builder()
                .email("emdail@email.com")
                .password("gksrlqja1!")
                .account("sgweg")
                .username("sdf")
                .build();
        //when
        boolean flag = userService.join(dto);
        //then
        assertTrue(flag);
        System.out.println("dto = " + dto);
    }


    @Test
    @DisplayName("Success test.")
    void successTest() {
        //given
        LoginDto user = LoginDto.builder()
                .userName("hgb926")
                .password("gksrlqja1!")
                .build();
        //when
        LoginResult foundM = userService.authenticate(user);
        //then
        assertNotNull(foundM);
        System.out.println("foundM = " + foundM);
    }

    @Test
    @DisplayName("no password test.")
    void noPwTest() {
        //given
        LoginDto user = LoginDto.builder()
                .userName("hgb926")
                .password("wrongPassword")
                .build();
        //when
        LoginResult foundM = userService.authenticate(user);
        //then
        assertNotNull(foundM);
        System.out.println("foundM = " + foundM);
    }

    @Test
    @DisplayName("no account test.")
    void noAccTest() {
        //given
        LoginDto user = LoginDto.builder()
                .userName("swindfgs")
                .password("gksrlqja1!")
                .build();
        //when
        LoginResult foundM = userService.authenticate(user);
        //then
        assertNotNull(foundM);
        System.out.println("foundM = " + foundM);
    }


}