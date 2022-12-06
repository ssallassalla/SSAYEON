package com.ssayeon.ssayeon.member.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Embeddable
@NoArgsConstructor
public class Password {

    @Column(name = "password")
    // 암호화된 password
    // 비밀번호 규칙 형식 검증
    private String encodedPassword;


    public Password(String password) {
        validate(password);
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        this.encodedPassword = hashPassword;
    }

    private void validate(String password) {
        if (password == null || password.isBlank()) {
            throw new RuntimeException();
        }
    }
}
