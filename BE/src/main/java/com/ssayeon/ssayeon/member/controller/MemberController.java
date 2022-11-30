package com.ssayeon.ssayeon.member.controller;


import com.ssayeon.ssayeon.member.dto.MemberFormDto;
import com.ssayeon.ssayeon.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/members")
@Controller
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/users")
    public ResponseEntity<MemberResponse> signUp(@RequestBody @Valid final MemberFormDto memberRequest) {
        final MemberResponse memberResponse = memberService.saveMember(memberRequest);
    }

}
