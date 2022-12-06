package com.ssayeon.ssayeon.member.service;

import com.ssayeon.ssayeon.member.domain.Member;
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
        String password = signupRequest.getPassword();
        String passwordConfirmation = signupRequest.getPasswordConfirmation();
        validatePassword(password, passwordConfirmation);

        Member member = signupRequest.toEntity();
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    private void validatePassword(String password, String passwordConfirmation) {
        if (!password.equals(passwordConfirmation)) {
            throw new IllegalArgumentException("비밀번호 일치하지 않습니다.");
        }
    }

//    private Member addMember(SignupRequest signupRequest) {
//        return Member.builder()
//                .userEmail(signupRequest.getUserEmail())
//                .password(signupRequest.getPassword())
//                .campus(signupRequest.getCampus())
//                .nickname(signupRequest.getNickname())
//                .generation(signupRequest.getGeneration())
//                .build();
//    }
}
