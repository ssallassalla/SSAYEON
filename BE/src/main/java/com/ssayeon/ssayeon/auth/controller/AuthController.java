package com.ssayeon.ssayeon.auth.controller;

import com.ssayeon.ssayeon.auth.dto.AuthLoginRequestDto;
import com.ssayeon.ssayeon.auth.dto.TokenInfo;
import com.ssayeon.ssayeon.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final MemberService memberService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/login")
    public TokenInfo login(@RequestBody AuthLoginRequestDto authLoginRequestDto) {
        String username = authLoginRequestDto.getUsername();

        String password = authLoginRequestDto.getPassword();

        TokenInfo tokenInfo = memberService.login(username, password);
        return tokenInfo;
    }


}
