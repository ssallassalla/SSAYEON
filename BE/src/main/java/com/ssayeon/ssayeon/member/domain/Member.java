package com.ssayeon.ssayeon.member.domain;


import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Embedded
    private Username username;


    @Embedded
    private Password password;

    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;

    @Builder
    public Member(Long id, Username username, Password password) {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public static Member applicant(Username username, Password password) {
        Member member = new Member(null, username, password);
        member.roleType = RoleType.USER;
        return member;
    }


    public Long getId() {
        return id;
    }

    public boolean hasId(Long id) {
        return this.id.equals(id);
    }

    public String getUsername() {
        return username.getValue();
    }


    public String getPassword() {
        return password.getValue();
    }

    public RoleType getRoleType() {
        return roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Member member = (Member) o;
        return getId().equals(member.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}