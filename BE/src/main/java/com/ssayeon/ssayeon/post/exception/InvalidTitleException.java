package com.ssayeon.ssayeon.post.exception;


public class InvalidTitleException extends RuntimeException {

    private static final String MESSAGE = "제목은 1자 이상 50자 이하여야 합니다.";

    public InvalidTitleException() {
        super(MESSAGE);
    }

}