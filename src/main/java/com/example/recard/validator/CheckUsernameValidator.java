package com.example.recard.validator;

import com.example.recard.dto.UserDto;
import com.example.recard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;


@RequiredArgsConstructor
@Component
public class CheckUsernameValidator extends AbstractValidator<UserDto> {

    @Autowired
    UserRepository userRepository;

    @Override
    protected void doValidate(UserDto dto, Errors errors) {
        if(userRepository.existsByUsername(dto.getUsername())){
            errors.rejectValue("username", "닉네임 중복 오류", "이미 사용중인 닉네임 입니다.");
        }
    }
}
