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
    @DisplayName("저장 성공")
    void save() {
        //given
        User user = User.builder()
                .userName("hgb926")
                .password("gksrlqja1!")
                .email("hgb926@naver.com")
                .name("한기범")
                .build();
        //when
        boolean flag = userMapper.save(user);

        //then
        assertTrue(flag);
        System.out.println("user = " + user);
    }
    




  
}