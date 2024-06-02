package com.obligato.mvc.dto.request;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class LoginDto {
    private String username;
    private String password;

}
