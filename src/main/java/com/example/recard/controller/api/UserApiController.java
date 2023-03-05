package com.example.recard.controller.api;

import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.ProfilePhoto;
import com.example.recard.domain.User;
import com.example.recard.dto.ResponseDto;
import com.example.recard.dto.UserDto;
import com.example.recard.service.UserService;
import com.example.recard.validator.CheckEmailValidator;
import com.example.recard.validator.CheckUsernameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    @Autowired
    UserService userService;

    private final CheckEmailValidator checkEmailValidator;
    private final CheckUsernameValidator checkUsernameValidator;


    @InitBinder
    public void validatorBinder(WebDataBinder binder){
        binder.addValidators(checkEmailValidator);
        binder.addValidators(checkUsernameValidator);
    }


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


//
    @PostMapping("/user/image")
    public ResponseDto<?> ProfileInsert(HttpServletResponse response, @AuthenticationPrincipal PrincipalDetail principal,
                                @RequestParam("fileline")MultipartFile mfile) throws Exception {

        String redirectUrl = "/myPage";

        // 변경한 이미지가 없을 경우 처리
        if(mfile.isEmpty()){
            response.sendRedirect(redirectUrl);
            return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
        }

        //서버 PC에 맞는 경로별 수정 필요
        String uploadPath = "/Users/gimsang-u/Desktop/study/img/";

        UUID uuid = UUID.randomUUID();
        String extention = (mfile.getOriginalFilename()).substring(mfile.getOriginalFilename().lastIndexOf("."));
        // 파일 이름을 uuid형식.이미지확장자 로 변경
        String fileName = uuid + extention;

        Long userId = principal.getUser().getUser_id();
        Optional<ProfilePhoto> profilePhoto = userService.profilePhotoFind(userId);


        //기존 프로필 파일이 존재할 경우 제거
        try {
            if (profilePhoto.isEmpty() != true) {
                ProfilePhoto profile = userService.profilePhotoFind(userId)
                        .orElseThrow(() -> {
                            return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.: " + userId);
                        });

                //기존 레코드의 deleteAt 업데이트 쿼리
                userService.ProfilePhotoDeleteAtUpdate(profile);
                File file = new File(uploadPath + profile.getFileName());
                file.delete();

            }
            mfile.transferTo(new File(uploadPath + fileName));

        }catch(IllegalStateException | IOException e){
            e.printStackTrace();
        }

        // profilePhoto에 새로운 레코드 insert
        userService.ProfilePhotoSave(uploadPath, fileName, principal.getUser());

        response.sendRedirect(redirectUrl);

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }





}
