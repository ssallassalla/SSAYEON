package com.ssayeon.ssayeon.member.domain;

import java.util.Objects;
import java.util.regex.Pattern;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Password {

    @Column
    @Getter
    private String password;


    public Password(String password) {
        this.password = password;
    }

    private void validate(String password) {
        if (password == null || password.isBlank()) {
            throw new RuntimeException();
        }
    }
}