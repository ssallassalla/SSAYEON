package com.ssayeon.ssayeon.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Getter
public class MemberFormDto {
    @NotBlank
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Length(min = 4, max = 16)
    private String password;

    @Builder
    public MemberFormDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
