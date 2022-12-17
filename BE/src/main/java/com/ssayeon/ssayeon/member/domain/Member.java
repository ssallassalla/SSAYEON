package com.ssayeon.ssayeon.member.domain;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
public class Member implements UserDetails {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Username username;

    @Getter
    @Embedded
    private Nickname nickname;

    @Embedded
    private Password password;

    @Getter
    @Column(name = "generation")
    private String generation;

    @Getter
    @Enumerated(EnumType.STRING)
    @NotNull
    private Campus campus = Campus.GWANGJU;

    @Getter
    @Enumerated(EnumType.STRING)
    private RoleType roleType = RoleType.APPLICANT;

    @Getter
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Builder
    public Member(Long id, String username, String nickname, String password, String generation, String campus) {
        this.id = id;
        this.username = new Username(username);
        this.nickname = new Nickname(nickname);
        this.password = new Password(password);
        this.generation = generation;
        this.campus = Campus.from(campus);
        this.roleType = RoleType.APPLICANT;

        List<String> roles  = new ArrayList<>();
        roles.add("USER");
        this.roles = roles;
    }

    public Member(String username, String nickname, String password, String generation, String campus) {
        this(null, username, nickname, password, generation, campus);
    }

    //    public static Member applicant(Username username, Password password) {
//        Member member = new Member(null, username, password);
//        member.roleType = RoleType.APPLICANT;
//        return member;
//    }

    public boolean hasId(Long id) {
        return this.id.equals(id);
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username.getValue();
    }
    @Override
    public String getPassword() {
        return password.getEncodedPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}