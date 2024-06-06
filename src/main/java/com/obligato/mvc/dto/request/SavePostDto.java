package com.obligato.mvc.dto.request;


import lombok.*;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class SavePostDto {

    private String title;
    private String userName;
    private String content;
}
