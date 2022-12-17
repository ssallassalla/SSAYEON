package com.ssayeon.ssayeon.member.exception;

import com.ssayeon.ssayeon.advice.BadRequestException;

public class DuplicateUsernameException extends BadRequestException {
    private static final String MESSAGE = "이미 존재하는 이메일입니다.";

    public DuplicateUsernameException() {
        super(MESSAGE);
    }

}
