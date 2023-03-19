package com.example.recard.controller;

import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.Category;
import com.example.recard.domain.Schedule;
import com.example.recard.domain.UserLike;
import com.example.recard.service.ScheduleService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class scheduleController {
    Logger logger;
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
    public String main(Model model, @PageableDefault(sort = "likeCount", direction = Sort.Direction.DESC) Pageable pageable){

        Page<Schedule> schedules = scheduleService.schedulesSelect(pageable);
        //System.out.println(schedules.getContent());
        model.addAttribute("schedules", schedules);

        return "main";
    }

    // 메인화면 전체 랜더링
    @GetMapping("/schedules/all")            //한페이지에 스케줄 12개씩
    public String allschedules(Model model, @PageableDefault(size = 12,sort = "likeCount", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Schedule> schedules = scheduleService.schedulesSelect(pageable);
        model.addAttribute("schedules", schedules);
        return "mainall";

    }


    //스케줄 등록 화면 랜더링
    @GetMapping("/schedules")
    public String Schedules(){
      return "schedule/saveForm";
    }

    //카테고리 분류 선택 화면
//    @GetMapping("")
//    public String choiceCategory(){
//        return "schedule/"
//    }

    //카테고리별 스케줄 분류된 화면
    @GetMapping("")
    public String sortedCategory(){

    }


    @GetMapping("/category")
    public String Category(Model model){
        List<Category> categoryList = getAllCategories();
        for(Category category : categoryList){
            System.out.println("category["+ category + "]");
        }
        model.addAttribute("category", categoryList);
        return "schedule/selectCategory";
    }



    // build get all category REST API
    @GetMapping("/api/categories")
    public List<Category> getAllCategories(){
        return scheduleService.getAllCategories();
    }



    // 스케줄 상세 화면 랜더링
    @GetMapping("/details/{id}")
    public String Details(@PathVariable Long id, Model model,@AuthenticationPrincipal PrincipalDetail principal){

        //클라이언트가 비로그인 상태일 경우
        if(principal == null || principal.getUser() == null || principal.getUser().getUser_id() == null) {
            model.addAttribute("schedule", scheduleService.scheduleDetail(id));

        }
        else{
            model.addAttribute("schedule", scheduleService.scheduleDetail(id));

            UserLike userLike = scheduleService.likeYn(id, principal.getUser());
            model.addAttribute("userlike", userLike);

        }

        return "schedule/details";
    }

    //마이스케줄
    @GetMapping("/myList")
    public String MyList(Model model, @PageableDefault(size = 12,sort = "likeCount", direction = Sort.Direction.DESC)Pageable pageable,
                         @AuthenticationPrincipal PrincipalDetail principal){


        Page<Schedule> schedules = scheduleService.mySchedulesSelect(pageable, principal.getUser().getUser_id());
        model.addAttribute("schedules", schedules);
        return "user/myList";
    }

    //하트 스케줄함
    @GetMapping("/myHeartList")
    public String MyHeartList(Model model, @PageableDefault(size = 12,sort = "schedule.likeCount", direction = Sort.Direction.DESC)Pageable pageable,
                              @AuthenticationPrincipal PrincipalDetail principal){
        Page<UserLike> userLikes = scheduleService.heartScheduleSelect(pageable, principal.getUser().getUser_id());
        model.addAttribute("userLikes", userLikes);
        return "user/myHeartList";
    }


    @RequestMapping("/schedules")
    public String view(@ModelAttribute("category") Category category, Model model, HttpServletRequest request)
//    public String view(@RequestParam("cate") String cate, ModelMap model, HttpServletRequest request)

            throws Exception{
        request.setCharacterEncoding("utf-8");
        String reqCate = request.getParameter("cate");
        model.addAttribute("category", reqCate);
        System.out.println(reqCate);
        return "/schedules";
    }

}
