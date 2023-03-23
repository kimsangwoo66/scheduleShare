
package com.example.recard.controller.api;


import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.Schedule;
import com.example.recard.domain.SchedulePhoto;
import com.example.recard.dto.ResponseDto;
import com.example.recard.dto.ScheduleDto;
import com.example.recard.service.ScheduleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
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




    //스케줄 등록 api
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
                scheduleService.schedulePhotoSave(uploadPath, fileName, mfile.getOriginalFilename(), schedule);

            }catch(IllegalStateException | IOException e){
                e.printStackTrace();
            }



        }

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }



    //스케줄 수정 api
    @PutMapping("/api/schedule")
    public ResponseDto<Integer> scheduleEdit(@RequestPart("attach_file") List<MultipartFile> files,
                                             @RequestPart("schedule") ScheduleDto scheduleDto,
                                             @AuthenticationPrincipal PrincipalDetail principal) throws Exception{

        Schedule schedule = scheduleService.ScheduleFinalUpdate(scheduleDto);

        //기존에 업로드된 스케줄이미지 사진 전부 제거
        List<SchedulePhoto> allSphoto = scheduleService.findAllSphoto(scheduleDto);
        for(SchedulePhoto sphotoInfo: allSphoto){
            System.out.println("현재 스케줄에 저장된 이미지들: " + sphotoInfo.getFileName());

            try{

                File file = new File(uploadPath + sphotoInfo.getFileName());
                file.delete();
                scheduleService.deleteSphoto(sphotoInfo.getSphoto_id());
                System.out.println("파일 정상 삭제 확인");
            }catch(IllegalStateException e){
                e.printStackTrace();
            }
        }


        String extension = "";
        String fileName = "";

        for(MultipartFile mfile: files){

            uuid = UUID.randomUUID();
            System.out.println(mfile.getOriginalFilename());

            extension = (mfile.getOriginalFilename()).substring(mfile.getOriginalFilename().lastIndexOf("."));
            fileName = uuid + extension;

            try{

                // 실제 서버 경로에 파일 업로드
                mfile.transferTo(new File(uploadPath + fileName));
                scheduleService.schedulePhotoUpdate(uploadPath, fileName, mfile.getOriginalFilename(), schedule);

            }catch(IllegalStateException | IOException e){
                e.printStackTrace();
            }



        }

        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }


    @PostMapping("/api/likecnt")
    @ResponseBody
    public ResponseDto<Integer> likeCnt(Long schedule_id, @AuthenticationPrincipal PrincipalDetail principal)  {

        Long user_id = principal.getUser().getUser_id();
        System.out.println("스케줄아이디: " + schedule_id);
        System.out.println("유저아이디: " + user_id);
        scheduleService.likeCheck(schedule_id, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    //스케줄의 사진들의 이름들을 조회후 js로 보내서 formData 에 담기위한 API
    @GetMapping("/Images")
    public List<String> getImagePaths(@RequestParam("schedule_id") Long scheduleId) {
        List<SchedulePhoto> allSphoto = scheduleService.findAllSphoto(scheduleId);
        List<String> imagePaths = new ArrayList<>();
        for(SchedulePhoto sphotoInfo: allSphoto){

            String fileName = sphotoInfo.getFileName();
            imagePaths.add(fileName);
        }
        return imagePaths;
    }




}

