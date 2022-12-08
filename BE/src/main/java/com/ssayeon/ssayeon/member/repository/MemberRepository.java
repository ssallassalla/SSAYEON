package com.ssayeon.ssayeon.member.repository;

import com.ssayeon.ssayeon.member.domain.Member;
import com.ssayeon.ssayeon.member.domain.Nickname;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long> {

    boolean existsMemberByNicknameValue(String nickname);

    boolean existsMemberByNickname(Nickname validNickname);

    boolean existsMemberByUserEmailValue(String userEmail);

}
