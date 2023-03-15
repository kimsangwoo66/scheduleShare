package com.example.recard.service;

import com.example.recard.domain.Category;
import com.example.recard.domain.Schedule;
import com.example.recard.domain.SchedulePhoto;
import com.example.recard.domain.User;
import com.example.recard.dto.ScheduleDto;
import com.example.recard.repository.CategoryRepository;
import com.example.recard.repository.SchedulePhotoRepository;
import com.example.recard.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    SchedulePhotoRepository schedulePhotoRepository;

    //카테고리 다 가져오기
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category categoryGetId(long id){
        return categoryRepository.findById(id).orElseThrow();
    }


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
    public Schedule ScheduleFinalSave(ScheduleDto scheduleDto, User user){

        //optional은 .get()으로 객체를 가져올 수 있음
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


        return scheduleInfo;
    }

    @Transactional
    public void schedulePhotoSave(String uploadPath, String fileName, Schedule schedule){
        String fullUploadPath = uploadPath + fileName;



        SchedulePhoto schedulePhoto = SchedulePhoto.builder()
                .physicalPath(fullUploadPath)
                .fileName(fileName)
                .schedule(schedule)
                .build();


        schedulePhotoRepository.save(schedulePhoto);

    }

    @Transactional(readOnly = true)
    public Page<Schedule> schedulesSelect(Pageable pageable){

        return scheduleRepository.findAll(pageable);

    }

    @Transactional
    public Schedule scheduleDetail(Long id){
        return scheduleRepository.findById(id).
                orElseThrow(() -> {
                    return new IllegalArgumentException("스케줄 상세보기 실패: schedule_id를 찾을 수 없음");
                });

    }



}
