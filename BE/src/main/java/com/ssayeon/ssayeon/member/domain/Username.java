package com.ssayeon.ssayeon.member.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Username {


    @Column(name = "username")
    private String value;

    protected Username() {
    }

    public Username(String value) {
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
        Username username = (Username) o;
        return getValue().equals(username.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}