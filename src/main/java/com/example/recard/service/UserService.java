package com.example.recard.service;

import com.example.recard.domain.RoleType;
import com.example.recard.domain.User;
import com.example.recard.dto.UserDto;
import com.example.recard.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;


//    @Transactional
//    public void userSave(User user){
//
//            String rawPassword = user.getPassword();
//            String encPassword = encoder.encode(rawPassword);
//
//            user.setPassword(encPassword);
//            user.setRole(RoleType.USER);
//            userRepository.save(user);
//
//
//    }

    @Transactional
    public void userSave(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .username(userDto.getUsername())
                .state(userDto.getState())
                .gender(userDto.getGender())
                .role(RoleType.USER)
                .build();
        userRepository.save(user);
    }

    // Controller에서 발생한 에러를 전달받아 알맞게 정재한 뒤에 다시 반환
    @Transactional(readOnly = true)
    public Map<String, String> validateHandling(BindingResult bindingResult){
        Map<String, String> validatorResult = new HashMap<>();

        for(FieldError error: bindingResult.getFieldErrors()){

            System.out.println("errorField: " + error.getField());
            String validateKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validateKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }


}
