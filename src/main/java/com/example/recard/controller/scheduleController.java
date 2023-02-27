package com.example.recard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    //마이페이지
    @GetMapping("/myPage")
    public String MyPage(){
        return "user/myPage";
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
