package com.obligato.mvc.service;

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

    public List<PostResponseDto> findAll() {
        List<Post> postList = postMapper.findAll();
        List<PostResponseDto> dtoList = postList.stream()
                .map(p -> new PostResponseDto(p))
                .collect(Collectors.toList());
        return dtoList;
    }


}
