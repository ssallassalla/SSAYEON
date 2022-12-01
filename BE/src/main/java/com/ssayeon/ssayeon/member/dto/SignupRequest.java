package com.ssayeon.ssayeon.member.dto;

import com.ssayeon.ssayeon.member.domain.Campus;
import com.ssayeon.ssayeon.member.domain.Nickname;
import com.ssayeon.ssayeon.member.domain.Password;
import com.ssayeon.ssayeon.member.domain.UserEmail;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class SignupRequest {

    @NotBlank(message = "이메일 형식으로 작성해야 합니다.")
    private String userEmail;

    @NotBlank(message = "닉네임은 1자 이상 16자 이상이여야 합니다.")
    private String nickname;

    @NotBlank
    private String password;

//    @NotBlank
    private String passwordConfirmation;

    @NotBlank(message = "기수 확인필요")
    private String generation;

    @NotNull(message = "캠퍼스 확인")
    private String campus;

    public SignupRequest() {

    }

    public SignupRequest(String userEmail, String nickname, String password, String passwordConfirmation, String generation, String campus) {
        this.userEmail = userEmail;
        this.nickname = nickname;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
        this.generation = generation;
        this.campus = campus;
    }
}
