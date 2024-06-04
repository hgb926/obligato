package com.obligato.mvc.dto.request;

import com.obligato.mvc.entity.User;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UserSignUpDto {

//    @NotBlank(message = "아이디는 필수값입니다.")
//    @Size(min = 4, max = 14, message = "아이디는 4~14글자")
//    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "아이디는 영문과 숫자만 포함해야 합니다.")
    private String account;

//    @NotBlank
    private String password;

//    @NotBlank
//    @Size(min = 2, max = 6)
    private String username;

//    @NotBlank
//    @Email
    private String email;

    public User toEntity() {
        return User.builder()
                .username(this.account)
                .password(this.password)
                .email(this.email)
                .name(this.username)
                .build();
    }
}
