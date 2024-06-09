package com.obligato.mvc.dto.response;

import com.obligato.mvc.entity.User;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class LoginUserInfoDto {
    // 클라이언트에 보낼 정제된 정보
    private String account;
    private String userName;
    private String email;


    public LoginUserInfoDto(User user) {
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.account = user.getName();
    }
}
