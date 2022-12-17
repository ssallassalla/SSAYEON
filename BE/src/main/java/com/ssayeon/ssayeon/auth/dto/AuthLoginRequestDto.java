package com.ssayeon.ssayeon.auth.dto;

import lombok.Data;

@Data
public class AuthLoginRequestDto {
    private String username;
    private String password;
}
