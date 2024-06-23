package com.obligato.mvc.controller;

import com.obligato.mvc.dto.request.LoginDto;
import com.obligato.mvc.dto.request.SignUpDto;
import com.obligato.mvc.entity.User;
import com.obligato.mvc.mapper.UserMapper;
import com.obligato.mvc.service.LoginResult;
import com.obligato.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;
    private final RequestContextFilter requestContextFilter;


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
    public String register(SignUpDto dto, HttpSession session) {
        log.debug("parameter: {}", dto);
        boolean flag = userService.join(dto);
        if (flag) {
            User user = dto.toEntity();
            session.setAttribute("user", user);
            return "redirect:/index";
        } else {
            return "redirect:/users/sign-up";
        }



    }

    @PostMapping("/sign-up")
    public String signUp(LoginDto dto, HttpServletResponse response, HttpServletRequest request) {
        log.debug("parameter: {}", dto);
        HttpSession session = request.getSession();
        LoginResult result = userService.authenticate(dto, session, response);

        switch (result) {
            case SUCCESS:
                String redirect = (String) session.getAttribute("redirect");
                if (redirect != null) session.removeAttribute("redirect");
                return "redirect:/index";
            case NO_ACC:
                return "redirect:/users/sign-up?error=no_access";
            case NO_PW:
                return "redirect:/users/sign-up?error=no_password";
        }
        return null;
    }

    @GetMapping("/sign-out")
    public String signOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/index";
    }


}
