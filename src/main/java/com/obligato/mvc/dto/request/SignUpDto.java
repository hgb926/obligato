package com.obligato.mvc.dto.request;

import com.obligato.mvc.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter @Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    @NotBlank
    @Size(min = 4, max = 14)
    private String account;

    @NotBlank
    private String password;


    @NotBlank
    @Size(min = 2, max = 6)
    private String username;

    @NotBlank
    @Email
    private String email;

    // 회원가입 controller 데이터 전송이 안되는 것 같음. 경로 등 확인 필요

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .userName(this.account)
                .name(this.username)
                .build();
    }
}
