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

    // 게시글 생성 시 받는 데이터가 한 매퍼(PostMapper)에서 처리할지,
    // 각각 해당되는 테이블의 매퍼들로 보낼지 고민을..
}
