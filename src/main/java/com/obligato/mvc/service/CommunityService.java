package com.obligato.mvc.service;

import com.obligato.mvc.dto.request.ModifyPostDto;
import com.obligato.mvc.dto.request.SavePostDto;
import com.obligato.mvc.dto.response.PostResponseDto;
import com.obligato.mvc.entity.Post;
import com.obligato.mvc.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityService {

    private final PostMapper postMapper;

    public List<PostResponseDto> findAll(String sort) {
        List<Post> postList = postMapper.findAll(sort);
        List<PostResponseDto> dtoList = postList.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
        return dtoList;
    }

    public void save(SavePostDto dto) {
        Post post = Post.builder()
                .userName(dto.getUserName())
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        log.info("Save post: {}", post);
        postMapper.save(post);
    }

    public Post findOne(int bno) {
        return postMapper.findOne(bno);
    }

    public void updateViewCount(int bno) {
        postMapper.updateViewCount(bno);
    }

    public void delete(int bno) {
        postMapper.delete(bno);
    }


    public void modify(ModifyPostDto dto) {
        postMapper.modify(dto);
    }
}
