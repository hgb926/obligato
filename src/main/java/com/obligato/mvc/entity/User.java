package com.obligato.mvc.entity;

import lombok.*;

import java.time.LocalDateTime;

/*
CREATE TABLE user
(
    user_id    INT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(255) NOT NULL,
    email      VARCHAR(100) NOT NULL UNIQUE,
    name       VARCHAR(100),
    role       VARCHAR(50)  NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
 */


@Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {

    private int userId; // 1, 2, 3 ...
    private String userName; // 계정명 (hgb926) 후보키
    @Setter
    private String password;
    private String email;
    private String name; // 유저닉네임(한기범)
    private LocalDateTime createdAt;
    private String sessionId;
    private LocalDateTime limitTime;
}
