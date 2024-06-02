package com.obligato;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.obligato.mvc.mapper")  // UserMapper 인터페이스가 위치한 패키지
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}