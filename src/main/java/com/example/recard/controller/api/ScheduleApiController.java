package com.example.recard.controller.api;


import com.example.recard.domain.Schedule;
import com.example.recard.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
