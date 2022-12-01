package com.ssayeon.ssayeon.member.service;

import com.ssayeon.ssayeon.member.domain.Member;
import com.ssayeon.ssayeon.member.domain.UserEmail;
import com.ssayeon.ssayeon.member.dto.SignupRequest;
import com.ssayeon.ssayeon.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long signup(SignupRequest signupRequest) {
        Member member = addMember(signupRequest);
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    private Member addMember(SignupRequest signupRequest) {
        return Member.builder()
                .userEmail(signupRequest.getUserEmail())
                .password(signupRequest.getPassword())
                .campus(signupRequest.getCampus())
                .nickname(signupRequest.getNickname())
                .generation(signupRequest.getGeneration())
                .build();
    }
}
