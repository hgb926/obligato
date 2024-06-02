package com.obligato.mvc.controller;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.UserSignUpDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.service.LoginResult;
import com.obligato.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @GetMapping("/sign-up")
    public String signUp() {
        return "users/sign-up";
    }

    @GetMapping("/register")
    public String register() {
        return "users/register";
    }

    @PostMapping("/register")
    public String register(@Validated UserSignUpDto dto) {
        log.info("Register user: {}", dto);
        boolean flag = userService.signUp(dto);
        return "users/welcome";
    }

    // 회원가입 -> Dto 만들어서 데이터 받고, mapper로 전송 -> db 처리 후 -> 홈으로 돌려보냄.

    @PostMapping("/sign-up")
    public String signUp(LoginDto dto, RedirectAttributes ra, HttpServletRequest request) {
        log.info("Sign up user: {}", dto);
        HttpSession session = request.getSession();

        LoginResult result = userService.authenticate(dto, session);
        ra.addFlashAttribute("result", result);

        // 혹시 세션에 리다이렉트 URL이 있다면
//            String redirect = (String) session.getAttribute("redirect");
//            if (redirect != null) {
//                session.removeAttribute("redirect");
//                return "redirect:" + redirect;
//            }

        // 로그인 검증 메서드 확인. 틀려도 넘어가짐

        if (result == LoginResult.SUCCESS) {
            // 로그인 성공시
            return "redirect:/index";
        }

        // 로그인 실패시
        return "redirect:/users/welcome";
    }


}
