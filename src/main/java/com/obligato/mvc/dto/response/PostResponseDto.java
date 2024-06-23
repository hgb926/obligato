package com.obligato.mvc.dto.response;

import com.obligato.mvc.entity.Post;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private int postId;
    private String title;
    private String userName;
    private int viewCount;
    private int replyCount;
    private String createdAt; // 문자열로 변경
    private String content;

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.userName = post.getUserName();
        this.viewCount = post.getViewCount();
        this.replyCount = post.getReplyCount();
        this.createdAt = formatCreatedAt(post.getCreatedAt()); // 포맷팅된 문자열로 설정
        this.content = post.getContent();
    }

    // 날짜를 포맷팅하여 반환하는 메서드 추가
    private String formatCreatedAt(LocalDateTime createdAt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd a HH:mm:ss");
        return createdAt.format(formatter);
    }
}