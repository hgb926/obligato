package com.obligato.mvc.entity;


import lombok.*;

import java.time.LocalDateTime;
/*
    post_id    INT AUTO_INCREMENT PRIMARY KEY,
    user_id    INT,
    title      VARCHAR(255) NOT NULL,
    content    TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES User (user_id)
 */

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    private int postId; // pk 1, 2, 3
    private String userName; // 계정명 (hgb926)
    private String title; // 제목
    private String content; // 내용
    private LocalDateTime createdAt;
    private int viewCount;
    private int replyCount;

}
