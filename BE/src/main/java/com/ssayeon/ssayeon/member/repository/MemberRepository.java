package com.ssayeon.ssayeon.member.repository;

import com.ssayeon.ssayeon.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member,Long> {
}
