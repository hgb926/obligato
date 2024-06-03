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
    public String register(@Validated UserSignUpDto dto) {
        log.info("Register user: {}", dto);
        boolean flag = userService.signUp(dto);
        return "users/welcome";
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        LoginUserInfoDto userInfo = (LoginUserInfoDto) session.getAttribute("userInfo");
        model.addAttribute("userInfo", userInfo);
        return "users/welcome";
    }


    // 회원가입 -> Dto 만들어서 데이터 받고, mapper로 전송 -> db 처리 후 -> 홈으로 돌려보냄.

    @PostMapping("/sign-up")
    public String signUp(LoginDto dto, RedirectAttributes ra, HttpServletRequest request) {
        log.info("Sign up user: {}", dto);
        HttpSession session = request.getSession();

        try {
            AuthResult authResult = userService.authenticate(dto, session);
            LoginResult result = authResult.getResult();

            if (result == LoginResult.SUCCESS) {
                // 로그인 성공시
                LoginUserInfoDto loginUserInfo = new LoginUserInfoDto(authResult.getFoundMember());
                ra.addFlashAttribute("result", result);
                session.setAttribute("userInfo", loginUserInfo); // 세션에 저장

                return "redirect:/users/welcome";
            }

            // 로그인 실패시
            ra.addFlashAttribute("result", "로그인 실패");
            return "redirect:/index";
        } catch (Exception e) {
            log.error("로그인 처리 중 오류 발생", e);
            ra.addFlashAttribute("result", "시스템 오류");
            return "redirect:/index";
        }
    }



}
