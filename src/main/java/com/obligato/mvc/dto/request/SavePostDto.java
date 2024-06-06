package com.obligato.mvc.dto.request;


import lombok.*;
import org.checkerframework.checker.units.qual.N;

@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavePostDto {

    private String title;
    private String writer;
    private String content;
}
