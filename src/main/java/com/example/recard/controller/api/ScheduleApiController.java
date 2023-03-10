package com.example.recard.controller.api;


import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.Schedule;
import com.example.recard.domain.SchedulePhoto;
import com.example.recard.dto.ResponseDto;
import com.example.recard.dto.ScheduleDto;
import com.example.recard.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping()
public class ScheduleApiController {
    private ScheduleService scheduleService;

    public ScheduleApiController(ScheduleService scheduleService) {
        super();
        this.scheduleService = scheduleService;
    }

    //build create schedule REST API
    @PostMapping("/api/scheduleCategory")
    public ResponseEntity<Schedule> scheduleCategorySave(@RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.scheduleCategorySave(schedule), HttpStatus.CREATED);
    }

    //build update schedule REST API
    // http://localhost:8080/api/schedules/1
    @PutMapping("/api/schedules/{schedule_id}")
    public ResponseEntity<Schedule> scheduleUpdate(@PathVariable("schedule_id") long schedule_id, @RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.scheduleUpdate(schedule, schedule_id), HttpStatus.OK);
    }


//    //스케줄 등록 api
//    @PostMapping("/api/schedule")
//    public ResponseDto<Integer> scheduleFinalSave(@RequestBody Schedule schedule, @AuthenticationPrincipal PrincipalDetail principal){
//        //System.out.println(schedule.toString());
//        scheduleService.ScheduleFinalSave(schedule, principal.getUser());
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }

    // Schedule schedule
    // MultipartHttpServletRequest filelist
    //스케줄 이미지 등록 api
    @PostMapping("/api/schedule")
    public ResponseDto<Integer> scheduleSave(@RequestPart("attach_file") List<MultipartFile> files,
                                             @RequestPart("schedule") ScheduleDto scheduleDto,
                                             @AuthenticationPrincipal PrincipalDetail principal){
        System.out.println(scheduleDto.toString());
        ScheduleDto schedule = scheduleService.ScheduleFinalSave(scheduleDto, principal.getUser());
        System.out.println("저장한값을 호출: " + schedule.toString());

        //schedule key값을 가지고 schedulePhoto 테이블에 insert 시켜야함
        for(MultipartFile mfile: files){
              System.out.println(mfile.getOriginalFilename());
          }

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


}
