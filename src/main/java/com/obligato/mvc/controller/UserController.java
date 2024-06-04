package com.obligato.mvc.controller;

import com.obligato.common.AuthResult;
import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.UserSignUpDto;
import com.obligato.mvc.dto.response.LoginUserInfoDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.service.LoginResult;
import com.obligato.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
@SessionAttributes("userInfo")
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
    public String register(UserSignUpDto dto, RedirectAttributes redirectAttributes) {
        log.info("Register user: {}", dto);
        userService.signUp(dto);
        redirectAttributes.addFlashAttribute("dto", dto);
        return "redirect:/users/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        LoginUserInfoDto userInfo = (LoginUserInfoDto) session.getAttribute("userInfo");
        model.addAttribute("userInfo", userInfo);
        return "users/welcome";
    }


    // 회원가입 -> Dto 만들어서 데이터 받고, mapper로 전송 -> db 처리 후 -> 홈으로 돌려보냄.

    @PostMapping("/sign-up")
    public String signUp(UserSignUpDto dto, RedirectAttributes redirectAttributes) {
        log.info("Sign up user: {}", dto);
        boolean flag = userService.signUp(dto);
        redirectAttributes.addFlashAttribute("userInfo", dto);
        return "redirect:/users/sign-up";
    }

}
