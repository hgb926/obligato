package com.obligato.mvc.mapper;

import com.obligato.mvc.entity.Post;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostMapperTest {

    @Autowired
    private PostMapper postMapper;


    @Test
    @DisplayName("저장 성공")
    void save() {
        //given
    Post post = Post.builder()
            .userName("hgb926")
            .title("두번째 글.")
            .content("잘 될거야 ㅋㅋㅋㅋㅋ")
            .build();
        boolean flag = postMapper.save(post);


        System.out.println("post = " + post);
        assertTrue(flag);
    }


    @Test
    @DisplayName("전체 조회")
    void findAll() {
        //given
        List<Post> list = postMapper.findAll();
        //when
        System.out.println("list = " + list);
        //then
        assertTrue(list.size() > 0);
    }



}