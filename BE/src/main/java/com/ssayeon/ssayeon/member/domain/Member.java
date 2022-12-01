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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @Email
    private UserEmail userEmail;

    @Embedded
    private Nickname nickname;

    @Embedded
    private Password password;

    @Column(name="generation")
    private String generation;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Campus campus = Campus.GWANGJU;

    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.USER;


    @Builder
    public Member(Long id, String userEmail, String nickname, String password, String generation, String campus) {
        this.id = id;
        this.userEmail = new UserEmail(userEmail);
        this.nickname = new Nickname(nickname);
        this.password = new Password(password);
        this.generation = generation;
        this.campus = Campus.from(campus);
    }

    //    public static Member applicant(Useremail userEmail, Password password) {
//        Member member = new Member(null, userEmail, password);
//        member.roleType = RoleType.APPLICANT;
//        return member;
//    }


    public Long getId() {
        return id;
    }

    public boolean hasId(Long id) {
        return this.id.equals(id);
    }


    public String getPassword() {
        return password.getPassword();
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