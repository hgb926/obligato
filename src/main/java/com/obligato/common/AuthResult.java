package com.obligato.common;

import com.obligato.mvc.entity.User;
import com.obligato.mvc.service.LoginResult;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
@Builder
public class AuthResult {
    private LoginResult result;
    private User foundMember;

    public AuthResult(LoginResult result, User foundMember) {
        this.result = result;
        this.foundMember = foundMember;
    }

    public LoginResult getResult() {
        return result;
    }

    public User getFoundMember() {
        return foundMember;
    }
}
