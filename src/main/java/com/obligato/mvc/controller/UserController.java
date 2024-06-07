package com.obligato.mvc.controller;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.SignUpDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/register")
    public String register() {
        System.out.println("come in register form");

        return "users/register";
    }

    @GetMapping("/sign-up")
    public String signUp() {
        return "users/sign-up";
    }

    @PostMapping("/register")
    public String register(SignUpDto dto) {
        log.debug("왜안됨??????");
        log.debug("parameter: {}", dto);
        boolean flag = userService.join(dto);
        return flag ? "redirect:/index" : "redirect:/users/sign-up";
    }

}
