package com.obligato.mvc.controller;

import com.obligato.mvc.dto.response.LoginUserInfoDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpSession;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addUserInfoToModel(HttpSession session, Model model) {
        LoginUserInfoDto userInfo = (LoginUserInfoDto) session.getAttribute("userInfo");
        if (userInfo != null) {
            model.addAttribute("userInfo", userInfo);
        }
    }
}