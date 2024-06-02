package com.obligato.mvc.controller;

import com.obligato.mvc.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    @GetMapping("/sign-up")
    public String signUp() {
        return "users/sign-up";
    }

    @GetMapping("/register")
    public String register() {
        return "users/register";
    }

//    @PostMapping("/register")
//    public String register(User user) {
//
//    }

    // 회원가입 -> Dto 만들어서 데이터 받고, mapper로 전송 -> db 처리 후 -> 홈으로 돌려보냄.


}
