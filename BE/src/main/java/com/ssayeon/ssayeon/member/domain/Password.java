package com.ssayeon.ssayeon.member.domain;

import com.ssayeon.ssayeon.member.exception.InvalidPasswordFormatException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.regex.Pattern;

@Getter
@Embeddable
@NoArgsConstructor
public class Password {
    // 영문, 숫자, 특수문자(@$!%*#?&) 포함, 8자 이상 20자 이하
    // ?=.* >> 최소 한 개 이상
    private static final Pattern PATTERN=Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,20}$");

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
        if (!PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordFormatException();
        }
    }
}
