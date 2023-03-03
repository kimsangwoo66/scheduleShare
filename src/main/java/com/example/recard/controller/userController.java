package com.example.recard.controller;

import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.ProfilePhoto;
import com.example.recard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class userController {

     @Autowired
     UserService userService;

     @GetMapping("/auth/login")
     public String login(@RequestParam(value = "error", required = false) String error,
                         @RequestParam(value = "exception", required = false) String exception,
                         Model model){

         model.addAttribute("error", error);
         model.addAttribute("exception", exception);

         return "user/login";
     }

     @GetMapping("/auth/join")
     public String join(){

         return "user/join";
     }


    //@AuthenticationPrincipal PrincipalDetail principal -> 로그인한 사용자 세션 정보를 갖고있는 어노테이션
    //마이페이지
    @GetMapping("/myPage")
    public String MyPage(Model model,@AuthenticationPrincipal PrincipalDetail principal){

        Long userId = principal.getUser().getUser_id();

        Optional<ProfilePhoto> profilePhoto = userService.profilePhotoFind(userId);
        if(profilePhoto.isEmpty() != true){
            ProfilePhoto profilePhotoNoEmpty = userService.profilePhotoFind(userId)
                    .orElseThrow(() -> {
                        return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.: " + userId);
                    });
            System.out.println(profilePhotoNoEmpty);
            model.addAttribute("profile",profilePhotoNoEmpty);
        }

        return "user/myPage";
    }

}
