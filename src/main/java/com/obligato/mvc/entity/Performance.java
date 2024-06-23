package com.obligato.mvc.entity;

import lombok.*;

import java.time.LocalDateTime;

/*
CREATE TABLE performance
(
    performance_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id        INT,
    title          VARCHAR(255) NOT NULL,
    description    TEXT,
    location       VARCHAR(255),
    date           DATE,
    created_at     TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User (user_id)
);
 */
@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Performance {
    // 연주 정보 테이블
    private int performanceId;
    private int userId;
    private int pay;
    private String title;
    private String description;
    private String location;
    private LocalDateTime date; // 연주 날짜
    private LocalDateTime createdAt; // 게시글 생성 시간
    private int postId;
}
