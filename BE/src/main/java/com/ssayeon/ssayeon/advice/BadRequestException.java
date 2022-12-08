package com.ssayeon.ssayeon.advice;


public class BadRequestException extends BusinessException {

    public BadRequestException(String message) {
        super(message);
    }
}
