package com.example.recard.controller.api;


import com.example.recard.domain.Schedule;
import com.example.recard.dto.ResponseDto;
import com.example.recard.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @PostMapping("/api/schedules")
    public ResponseEntity<Schedule> scheduleSave(@RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.scheduleSave(schedule), HttpStatus.CREATED);
    }

    //build update schedule REST API
    // http://localhost:8080/api/schedules/1
    @PutMapping("/api/schedules/{schedule_id}")
    public ResponseEntity<Schedule> scheduleUpdate(@PathVariable("schedule_id") long schedule_id, @RequestBody Schedule schedule){
        return new ResponseEntity<Schedule>(scheduleService.scheduleUpdate(schedule, schedule_id), HttpStatus.OK);
    }

    @PostMapping("/api/scheduleFile")
    public ResponseDto<Integer> testSchedule(MultipartHttpServletRequest filelst){
        Iterator<String> iters = filelst.getFileNames();
        String next = iters.next();

        List<MultipartFile> files = filelst.getFiles(next);
        for(int i=0;i < files.size() ;i++){
            System.out.println(files.get(i).getOriginalFilename());

        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


}
