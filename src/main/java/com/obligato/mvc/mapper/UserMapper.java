package com.obligato.mvc.mapper;

import com.obligato.mvc.dto.response.AutoLoginDto;
import com.obligato.mvc.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    // 로그인, 회원가입을 담당하는 매퍼
    boolean save(User user);

    // 회원 정보 개별 조회
    User findOne(String username);

    // 중복 확인 (아이디, 이메일)
    /**
     *
     * @param type - 어떤걸 중복검사 할지 (ex: account OR email)
     * @param keyword - 중복검사할 실제값
     * @return - 중복이면 true, 아니면 false
     */
    boolean existsById(@Param("type") String type, @Param("keyword") String keyword);

    void updateAutoLogin(AutoLoginDto dto);

    User findBySessionId(String sessionId);

}
