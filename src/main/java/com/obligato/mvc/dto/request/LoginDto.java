package com.obligato.mvc.dto.request;

import jdk.jfr.Timestamp;
import lombok.*;

@Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Setter
public class LoginDto {

    private String username; // camelcase 문제 생길 가능성
    private String password;
    private boolean autoLogin;
}
