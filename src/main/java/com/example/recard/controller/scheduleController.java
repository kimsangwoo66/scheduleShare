package com.example.recard.controller;

import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.ProfilePhoto;
import com.example.recard.service.ScheduleService;
import com.example.recard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class scheduleController {



    // 메인화면 요청받기
    @GetMapping("/")
    public String main(){

        return "main";
    }

    //스케줄 등록
    @GetMapping("/schedules")
    public String SchedulesRegiMain(){
      return "schedule/saveForm";
    }

    //스케줄 등록
    @GetMapping("/selectCategory")
    public String SelectCategory(){
        return "schedule/selectCategory";
    }

    //스케줄 상세화면
    @GetMapping("/details")
    public String Details(){
        return "schedule/details";
    }




    //마이스케줄 페이지
    @GetMapping("/myList")
    public String MyList(){
        return "user/myList";
    }

    //좋아요 화면
    @GetMapping("/myHeartList")
    public String MyHeartList(){
        return "user/myHeartList";
    }

}
