package com.obligato.mvc.entity;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PerformanceInstrument {
    private int performanceId;
    private int instrumentId;
    private int requiredCount; // 구인구직하는 연주자 수
}
