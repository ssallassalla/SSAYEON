package com.ssayeon.ssayeon.member.service;

import com.ssayeon.ssayeon.member.domain.Member;
import com.ssayeon.ssayeon.member.domain.Nickname;
import com.ssayeon.ssayeon.member.domain.UserEmail;
import com.ssayeon.ssayeon.member.dto.SignupRequest;
import com.ssayeon.ssayeon.member.dto.UniqueResponse;
import com.ssayeon.ssayeon.member.exception.DuplicateNicknameException;
import com.ssayeon.ssayeon.member.exception.DuplicateUserEmailException;
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
        validateUniqueNickname(new Nickname(signupRequest.getNickname()));
        validateUniqueUserEmail(signupRequest.getUserEmail());
        Member member = signupRequest.toEntity();
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }

    private void validatePassword(String password, String passwordConfirmation) {
        if (!password.equals(passwordConfirmation)) {
            throw new IllegalArgumentException("비밀번호 일치하지 않습니다.");
        }
    }

    public UniqueResponse checkUniqueNickname(String nickname) {
        boolean unique = !memberRepository.existsMemberByNicknameValue(nickname);
        return new UniqueResponse(unique);
    }

    private void validateUniqueNickname(Nickname validNickname) {
        if (memberRepository.existsMemberByNickname(validNickname)) {
            throw new DuplicateNicknameException();
        }
    }

    public UniqueResponse checkUniqueUserEmail(String userEmail) {
        boolean unique = !memberRepository.existsMemberByUserEmailValue(userEmail);
        return new UniqueResponse(unique);
    }

    private void validateUniqueUserEmail(String userEmail) {
        boolean isDuplicatedUsername = memberRepository
                .existsMemberByUserEmailValue(userEmail);
        if (isDuplicatedUsername) {
            throw new DuplicateUserEmailException();
        }
    }

}
