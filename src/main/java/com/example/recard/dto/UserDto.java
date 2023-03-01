package com.example.recard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//회원가입 입력 데이터 유효성 검사를 위한 별도의 DTO 생성
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    @NotBlank(message = "이메일 입력은 필수값 입니다.")
    @Pattern(regexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    @NotBlank(message = "비밀번호 입력은 필수값 입니다. ")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    @Pattern(regexp = "^(?=.*[a-z0-9ㄱ-ㅎ가-힣])[a-z0-9ㄱ-ㅎ가-힣]{2,15}$", message = "닉네임은 2~15자 내에서 한글,영어(소문자),숫자를 사용 할 수 있습니다.")
    private String username;


    private int gender;

    private int state;


}
