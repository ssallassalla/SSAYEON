package com.ssayeon.ssayeon.member.controller;


import com.ssayeon.ssayeon.member.dto.SignupRequest;
import com.ssayeon.ssayeon.member.dto.UniqueResponse;
import com.ssayeon.ssayeon.member.repository.MemberRepository;
import com.ssayeon.ssayeon.member.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService, MemberRepository memberRepository) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest signupRequest) {
        Long id = memberService.signup(signupRequest);
        return ResponseEntity.created(URI.create("/members/" + id)).build();
    }

    @GetMapping(value = "/signup/exists", params = "nickname")
    public ResponseEntity<UniqueResponse> validateUniqueNickname(@RequestParam String nickname) {
        UniqueResponse uniqueResponse = memberService.checkUniqueNickname(nickname);
        return ResponseEntity.ok(uniqueResponse);
    }

    @GetMapping(value = "/signup/exists", params = "username")
    public ResponseEntity<UniqueResponse> validateUniqueUsername(@RequestParam String username) {
        UniqueResponse uniqueResponse = memberService.checkUniqueUsername(username);
        return ResponseEntity.ok(uniqueResponse);
    }

}
