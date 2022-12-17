package com.ssayeon.ssayeon.member.service;

import com.ssayeon.ssayeon.auth.dto.TokenInfo;
import com.ssayeon.ssayeon.auth.token.JwtTokenProvider;
import com.ssayeon.ssayeon.member.domain.Member;
import com.ssayeon.ssayeon.member.domain.Nickname;
import com.ssayeon.ssayeon.member.dto.SignupRequest;
import com.ssayeon.ssayeon.member.dto.UniqueResponse;
import com.ssayeon.ssayeon.member.exception.DuplicateNicknameException;
import com.ssayeon.ssayeon.member.exception.DuplicateUsernameException;
import com.ssayeon.ssayeon.member.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    public MemberService(MemberRepository memberRepository, AuthenticationManagerBuilder authenticationManagerBuilder, JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public Long signup(SignupRequest signupRequest) {
        String password = signupRequest.getPassword();
        String passwordConfirmation = signupRequest.getPasswordConfirmation();
        validatePassword(password, passwordConfirmation);
        validateUniqueNickname(new Nickname(signupRequest.getNickname()));
        validateUniqueUsername(signupRequest.getUsername());
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

    public UniqueResponse checkUniqueUsername(String username) {
        boolean unique = !memberRepository.existsMemberByUsernameValue(username);
        return new UniqueResponse(unique);
    }

    private void validateUniqueUsername(String username) {
        boolean isDuplicatedUsername = memberRepository
                .existsMemberByUsernameValue(username);
        if (isDuplicatedUsername) {
            throw new DuplicateUsernameException();
        }
    }

    @Transactional
    public TokenInfo login(String username, String password) {

        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

//        logger.info("{} 출력", authenticationToken.getCredentials().toString()); // 출력확인  123456ddhd!

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        logger.info("{} 출력", authentication);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return tokenInfo;
    }

}
