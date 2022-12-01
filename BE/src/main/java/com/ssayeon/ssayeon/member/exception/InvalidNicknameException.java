package com.ssayeon.ssayeon.member.exception;


public class InvalidNicknameException extends RuntimeException {
    private static final String MESSAGE = "잘못된 닉네임 형식입니다.";

    public InvalidNicknameException() {
        super(MESSAGE);
    }
}
