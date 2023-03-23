package com.example.recard.controller;

import com.example.recard.config.auth.PrincipalDetail;
import com.example.recard.domain.Category;
import com.example.recard.domain.Schedule;
import com.example.recard.domain.UserLike;
import com.example.recard.service.ScheduleService;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class scheduleController {
    @Autowired
    ScheduleService scheduleService;

    //build get all schedule REST API
    @GetMapping("/api/schedules")
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @RequestMapping("/schedules")
        public String view(@ModelAttribute("schedule") Schedule schedule, ModelMap model, HttpServletRequest request)
//    public String view(@RequestParam("cate") String cate, ModelMap model, HttpServletRequest request)

            throws Exception{
            request.setCharacterEncoding("utf-8");
            String reqCate = request.getParameter("cate");
            model.addAttribute("category", reqCate);
            return "/schedule/saveForm";
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

        model.addAttribute("schedules", schedules);

        return "main";
    }



    //스케줄 등록 화면 랜더링
    @GetMapping("/schedules")
    public String Schedules(){
      return "schedule/saveForm";
    }

    //스케줄 수정 화면 랜더링
    @GetMapping("/schedules/{id}")
    public String SchedulesEdit(@PathVariable("id") Long scheduleId, Model model){
        Schedule schedule = scheduleService.scheduleDetail(scheduleId);
        //System.out.println(schedule.get);
        model.addAttribute("schedule", schedule);

        return "schedule/updateForm";
    }

    //카테고리 분류 선택 화면
    @GetMapping("/cateSelection")
    public String choiceCategory(Model model){
        List<Category> categoryList = getAllCategories();

        model.addAttribute("category", categoryList);
        return "schedule/selectCategory";
    }

    //카테고리별 전체 스케줄 정렬 화면 랜더링
    @GetMapping("/cateSelection/{id}")
    public String cateChoose(@PathVariable("id") Long categoryId, Model model,
                             @PageableDefault(sort = "likeCount", direction = Sort.Direction.DESC) Pageable pageable){

        Page<Schedule> schedules = scheduleService.cateScheduleSelect(pageable, categoryId);


        model.addAttribute("schedules", schedules);
        return "mainCategory";
    }


    //전체 스케줄 화면 랜더링
    @GetMapping("/schedules/all")            //한페이지에 스케줄 12개씩
    public String allschedules(Model model, @PageableDefault(size = 12,sort = "likeCount", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Schedule> schedules = scheduleService.schedulesSelect(pageable);
        model.addAttribute("schedules", schedules);
        return "mainall";

    }


    @GetMapping("/category")
    public String Category(Model model){
        List<Category> categoryList = getAllCategories();
        for(Category category : categoryList){
            System.out.println("category["+ category + "]");
        }
        model.addAttribute("category", categoryList);
        return "schedule/saveCategory";
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
            model.addAttribute("principal", principal);
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


    @PostMapping("/api/category")
    public String category(@RequestParam("cate") String cate,
                           ModelMap model){

        String insideStr = cate.substring(cate.indexOf("(") + 1, cate.lastIndexOf(")"));
        String[] arr = insideStr.split(",");
        String cateId = arr[0].split("=")[1].trim();
        String cateName = arr[1].split("=")[1].trim();

        System.out.println("cateObj: " + cate);
        System.out.println("cateId:" + cateId);
        System.out.println("cateName: " + cateName);

        model.addAttribute("cateName", cateName);
        model.addAttribute("cateId", cateId);

        return "/schedule/saveForm";
    }

}
