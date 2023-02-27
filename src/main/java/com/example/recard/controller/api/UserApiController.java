package com.example.recard.controller.api;

import com.example.recard.domain.User;
import com.example.recard.dto.ResponseDto;
import com.example.recard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    //ResonseDto에 왜 integer 타입을 넣었지?
    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user){
        userService.userSave(user);

        //정상적으로 작동할경우 http 상태코드와 , 데이터 1반환
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
