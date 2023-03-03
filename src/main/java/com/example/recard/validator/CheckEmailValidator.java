package com.example.recard.validator;

import com.example.recard.dto.UserDto;
import com.example.recard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@RequiredArgsConstructor
@Component
public class CheckEmailValidator extends AbstractValidator<UserDto>{

    @Autowired
    UserRepository userRepository;
    @Override
    protected void doValidate(UserDto dto, Errors errors) {
        if(userRepository.existsByEmail(dto.getEmail())){
            errors.rejectValue("email","이메일 중복 오류", "이미 사용중인 이메일 입니다.");
        }
    }
}
