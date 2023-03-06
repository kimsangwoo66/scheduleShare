package com.example.recard.service;

import com.example.recard.domain.Schedule;
import com.example.recard.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        super();
        this.scheduleRepository = scheduleRepository;
    }

    public Schedule scheduleSave(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public Schedule scheduleUpdate(Schedule schedule, long id){
        // check whether schedule with given id exist in DB or not
        Schedule existingSchedule = scheduleRepository.findById(id).orElseThrow();
//        existingSchedule.setUser_id(schedule.getUser_id());
        existingSchedule.setTitle(schedule.getTitle());
        existingSchedule.setContent(schedule.getContent());
        //save existing schedule to DB
        scheduleRepository.save(existingSchedule);

        return existingSchedule;
    }

    public Schedule scheduleGetId(long id){
//        Optional<Schedule> schedule = scheduleRepository.findById(id);
//        if(schedule.isPresent()){
//            return schedule.get();
//        } else{
//            System.out.println("@@@@@@@@@@@ ERROR");
//        }
        return scheduleRepository.findById(id).orElseThrow();
    }


}
