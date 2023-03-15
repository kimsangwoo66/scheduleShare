package com.example.recard.controller.api;


import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.Category;
import com.example.recard.domain.Schedule;
import com.example.recard.dto.ResponseDto;
import com.example.recard.dto.ScheduleDto;
import com.example.recard.service.ScheduleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
//@RequestMapping()
public class ScheduleApiController {
    private ScheduleService scheduleService;

    UUID uuid;

    //application.properties의 설정 외부 경로 값 맵핑
    @Value("${resource.path}")
    String uploadPath;

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




    //스케줄 이미지 등록 api
    @PostMapping("/api/schedule")
    public ResponseDto<Integer> scheduleSave(@RequestPart("attach_file") List<MultipartFile> files,
                                             @RequestPart("schedule") ScheduleDto scheduleDto,
                                             @AuthenticationPrincipal PrincipalDetail principal){

        //서버 PC에 맞는 경로별 수정 필요



        String extension = "";
        String fileName = "";

        Schedule schedule = scheduleService.ScheduleFinalSave(scheduleDto, principal.getUser());
        System.out.println("저장한값을 호출: " + schedule.toString());

        for(MultipartFile mfile: files){
            uuid = UUID.randomUUID();
            System.out.println(mfile.getOriginalFilename());
            extension = (mfile.getOriginalFilename()).substring(mfile.getOriginalFilename().lastIndexOf("."));
            fileName = uuid + extension;

            try{
                // 실제 서버 경로에 파일 업로드
                mfile.transferTo(new File(uploadPath + fileName));
                scheduleService.schedulePhotoSave(uploadPath, fileName, schedule);

            }catch(IllegalStateException | IOException e){
                e.printStackTrace();
            }



          }

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    @PostMapping("/api/category")
    public ResponseEntity<Category> category(@RequestBody long category){
        return new ResponseEntity<Category>(scheduleService.categoryGetId(category), HttpStatus.OK);
    }


}
