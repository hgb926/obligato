package com.obligato.mvc.dto.response;


import com.obligato.mvc.entity.Post;
import lombok.*;

import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private String title;
    private String userName;
    private int viewCount;
    private int replyCount;
    private String createdAt;


    public PostResponseDto(Post post) {
        this.title = post.getTitle();
        this.userName = post.getUserName();
        this.viewCount = post.getViewCount();
        this.replyCount = post.getReplyCount();
        this.createdAt = post.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

    }

}
