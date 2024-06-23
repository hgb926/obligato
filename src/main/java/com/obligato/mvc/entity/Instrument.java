package com.obligato.mvc.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instrument {
    private int instrumentId;
    private String name;
}
