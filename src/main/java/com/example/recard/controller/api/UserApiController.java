package com.example.recard.controller.api;

import com.example.recard.domain.User;
import com.example.recard.dto.ResponseDto;
import com.example.recard.dto.UserDto;
import com.example.recard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;


//    @PostMapping("/auth/joinProc")
//    public ResponseDto<Integer> save(@RequestBody User user){
//        userService.userSave(user);
//
//        //정상적으로 작동할경우 http 상태코드와 , 데이터 1반환
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }

    @PostMapping("/auth/joinProc")
    public ResponseDto<?> save(@Valid @RequestBody UserDto userDto, BindingResult bindingResult){

        //회원가입 데이터 유효성 검사
        if(bindingResult.hasErrors()){
            Map<String, String> validatorResult = userService.validateHandling(bindingResult);

            // 유효성 검사에 실패할 경우 http 실패코드(400) 및 실패 원인 반환
            return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), validatorResult);
        }

        userService.userSave(userDto);

        //정상적으로 작동할경우 http 정상 동작 상태코드와 데이터 1 반환
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
