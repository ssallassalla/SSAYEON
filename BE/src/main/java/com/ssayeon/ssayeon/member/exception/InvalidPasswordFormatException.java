package com.ssayeon.ssayeon.member.exception;

public class InvalidPasswordFormatException extends RuntimeException{
    private static final String MESSAGE = "비밀번호 형식에 맞게 입력 해주세요.";

    public InvalidPasswordFormatException(){
        super(MESSAGE);
    }
}
