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

    //스케줄 등록(카테고리)



    //스케줄 등록
    @GetMapping("/schedules")
    public String SchedulesRegiMain(){
      return "schedule/saveForm";
    }


}
