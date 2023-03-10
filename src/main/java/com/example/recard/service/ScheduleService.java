package com.example.recard.service;

import com.example.recard.domain.Category;
import com.example.recard.domain.Schedule;
import com.example.recard.domain.User;
import com.example.recard.dto.ScheduleDto;
import com.example.recard.repository.CategoryRepository;
import com.example.recard.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    //스케줄 등록과 스케줄 카테고리 등록 구분해야 하기 떄문에
    //scheduleSave -> scheduleCategorySave로 함수 명칭 변경
    public Schedule scheduleCategorySave(Schedule schedule){
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

    @Transactional
    public ScheduleDto ScheduleFinalSave(ScheduleDto scheduleDto, User user){

        Optional<Category> category = categoryRepository.findById(scheduleDto.getCategory().getCategory_id());

        Schedule schedule = Schedule.builder()
                .title(scheduleDto.getTitle())
                .content(scheduleDto.getContent())
                .likeCount(scheduleDto.getLikeCount())
                .state(scheduleDto.getState())
                .moneyCost(scheduleDto.getMoneyCost())
                .timeCost(scheduleDto.getTimeCost())
                .user(user)
                .category(category.get())
                .build();

        Schedule scheduleInfo = scheduleRepository.save(schedule);


        ScheduleDto savedSchedule = new ScheduleDto();
        savedSchedule.setSchedule_id(scheduleInfo.getSchedule_id());
        savedSchedule.setTitle(scheduleInfo.getTitle());
        savedSchedule.setContent(scheduleInfo.getContent());
        savedSchedule.setLikeCount(scheduleInfo.getLikeCount());
        savedSchedule.setState(scheduleInfo.getState());
        savedSchedule.setMoneyCost(scheduleInfo.getMoneyCost());
        savedSchedule.setTimeCost(scheduleInfo.getTimeCost());
        savedSchedule.setUpdateAt(scheduleInfo.getUpdateAt());
        savedSchedule.setDeleteAt(scheduleInfo.getDeleteAt());
        savedSchedule.setUser(scheduleInfo.getUser());
        savedSchedule.setCategory(scheduleInfo.getCategory());


        return savedSchedule;
    }

    @Transactional
    public void schedulePhotoSave(MultipartFile mfile){


    }


}
