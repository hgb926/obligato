package com.obligato.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String index() {

        return "index";
    }


    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}

