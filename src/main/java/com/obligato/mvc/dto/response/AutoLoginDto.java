package com.obligato.mvc.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class AutoLoginDto {

    private String sessionId; // 자동로그인 쿠키값
    private LocalDateTime limitTime; // 만료시간
    private String account; // 계정명

}