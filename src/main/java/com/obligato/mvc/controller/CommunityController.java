package com.obligato.mvc.controller;

import com.obligato.mvc.dto.request.ModifyPostDto;
import com.obligato.mvc.dto.request.SavePostDto;
import com.obligato.mvc.dto.response.PostResponseDto;
import com.obligato.mvc.entity.Post;
import com.obligato.mvc.service.CommunityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/community")
@Slf4j
@RequiredArgsConstructor
public class CommunityController {

    private final CommunityService communityService;

    @GetMapping("/list")
    public String list(@RequestParam(defaultValue = "newest") String sort, Model model) {
        List<PostResponseDto> postList = communityService.findAll(sort);
        model.addAttribute("postList", postList);
        return "community/list";
    }

    @GetMapping("/write")
    public String write() {
        return "community/write";
    }

    @PostMapping("/write")
    public String writePost(SavePostDto dto) {
        communityService.save(dto);
        log.info("dto: {}", dto.toString());
        return "redirect:/community/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam int bno, Model model) {
        PostResponseDto foundPost = communityService.findOne(bno);

        communityService.updateViewCount(bno);
        model.addAttribute("post", foundPost);

        return "community/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int bno) {
        communityService.delete(bno);
        return "redirect:/community/list";
    }


    @GetMapping("/modify")
    public String modify(int bno, Model model) {
        PostResponseDto foundPost = communityService.findOne(bno);
        model.addAttribute("post", foundPost);
        return "community/modify";
    }

    @PostMapping("/modify")
    public String modifyPost(ModifyPostDto dto) {
        communityService.modify(dto);
        return "redirect:/community/detail?bno=" + dto.getPostId();
    }



}
