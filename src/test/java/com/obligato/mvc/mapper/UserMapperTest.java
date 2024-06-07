package com.obligato.mvc.mapper;

import com.obligato.mvc.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
@Rollback
class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;


    
    @Test
    @DisplayName("저장 성공")
    void save() {
        //given
        User user = User.builder()
                .userName("sdfsf")
                .password("gksrlqja1!")
                .email("hgb92s76@naver.com")
                .name("zzzzdg")
                .build();
        //when
        boolean flag = userMapper.save(user);

        //then
        assertTrue(flag);
        System.out.println("user = " + user);
    }
    




  
}