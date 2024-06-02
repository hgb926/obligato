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
    private String name;
    private String nickName;
    private String email;


    public LoginUserInfoDto(User user) {
        this.name = user.getUsername();
        this.email = user.getEmail();
        this.nickName = user.getName();
//        this.auth = user.getAuth().toString();

        /*
            private int userId;
    private String username; // 유저 실명
    @Setter
    private String password;
    private String email;
    private String name; // 계정명
    private LocalDateTime createdAt;
         */
    }

}
