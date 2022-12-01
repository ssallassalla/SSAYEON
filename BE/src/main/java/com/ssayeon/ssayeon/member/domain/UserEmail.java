package com.ssayeon.ssayeon.member.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class UserEmail {


    @Column(name = "userEmail")
    private String value;

    protected UserEmail() {
    }

    public UserEmail(String value) {
        this.value = value;
    }

//    public static Username of(EncryptorI encryptorI, String value) {
//        validate(value);
//        return new Username(encryptorI.encrypt(value));
//    }
//
//    private static void validate(String value) {
//        if (!PATTERN.matcher(value).matches()) {
//            throw new InvalidUsernameException();
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEmail useremail = (UserEmail) o;
        return getValue().equals(useremail.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}