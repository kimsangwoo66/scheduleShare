package com.example.recard.controller.api;


import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.Schedule;
import com.example.recard.dto.ResponseDto;
import com.example.recard.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleApiController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/api/regiSchedule")
    public ResponseDto<Integer> save(@RequestBody Schedule schedule, @AuthenticationPrincipal PrincipalDetail principal){
        scheduleService.write(schedule, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

}
