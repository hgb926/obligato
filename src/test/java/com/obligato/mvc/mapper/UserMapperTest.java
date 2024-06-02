package com.obligato.mvc.mapper;

import com.obligato.mvc.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;
    
    
    @Test
    @DisplayName("조회 성공")
    void findOne() {
        //given
        User one = userMapper.findOne(1);
        //when
        System.out.println("one = " + one);

        
        //then
    }


    @Test
    @DisplayName("저장 성공")
    void save() {
        //given
        User user = User.builder()
                .username("foreign")
                .name("ddd")
                .password("asdfasdfd!")
                .email("hgb9266@naver.com")
                .build();
        //when
        boolean flag = userMapper.save(user);

        //then
        System.out.println("flag = " + flag);
    }


  
}