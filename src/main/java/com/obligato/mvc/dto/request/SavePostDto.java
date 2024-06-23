package com.obligato.mvc.dto.request;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String instruments;
    private String location;
    private String pay;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    // 잘 들어온다.


}
