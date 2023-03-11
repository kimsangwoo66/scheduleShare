package com.example.recard.controller;

import com.example.recard.domain.Schedule;
import com.example.recard.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class scheduleController {
    @Autowired
    ScheduleService scheduleService;

    //build get all schedule REST API
    @GetMapping("/api/schedules")
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }


    //build get all schedule by id REST API
    // http://localhost:8080/api/schedules/1
    @GetMapping("/api/schedules/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable("id") long scheduleId){
        return new ResponseEntity<Schedule>(scheduleService.scheduleGetId(scheduleId), HttpStatus.OK);
    }

    // 메인화면 랜더링
    @GetMapping("/")
    public String main(){
        return "main";
    }

    //스케줄 등록 화면 랜더링
    @GetMapping("/schedules")
    public String Schedules(){
      return "schedule/saveForm";
    }

    //스케줄 카테고리 등록 화면 랜더링
//    @GetMapping("/category")
//    public String Category(){
//        return "schedule/selectCategory";
//    }
    @GetMapping("/category")
    public String Category(Model model){
        List<Schedule> scheduleList = getAllSchedules();
        System.out.println(scheduleList);
        model.addAttribute("category", scheduleList);
        return "schedule/selectCategory";
    }


    //스케줄 상세 화면 랜더링
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
