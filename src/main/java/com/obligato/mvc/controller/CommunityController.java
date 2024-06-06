package com.obligato.mvc.controller;

import com.obligato.mvc.dto.request.SavePostDto;
import com.obligato.mvc.dto.response.PostResponseDto;
import com.obligato.mvc.entity.Post;
import com.obligato.mvc.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/community")
@Slf4j
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/list")
    public String list(Model model) {
        List<PostResponseDto> postList = communityService.findAll();
        model.addAttribute("postList", postList);
        return "community/list";
    }

    @GetMapping("/write")
    public String write() {
        return "community/write";
    }

//    @PostMapping("/write")
//    public String writePost(SavePostDto dto) {
//
//    }

}
