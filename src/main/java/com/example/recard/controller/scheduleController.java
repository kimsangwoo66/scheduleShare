package com.example.recard.controller;

import com.example.recard.domain.Category;
import com.example.recard.domain.Schedule;
import com.example.recard.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< Updated upstream
=======
import org.springframework.ui.ModelMap;
>>>>>>> Stashed changes
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
            System.out.println(reqCate);
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
        System.out.println(schedules.getContent());
        model.addAttribute("schedules", schedules);

        return "main";
    }



    //스케줄 등록 화면 랜더링
    @GetMapping("/schedules")
    public String Schedules(){
      return "schedule/saveForm";
    }


    @GetMapping("/category")
    public String Category(Model model){
        List<Category> categoryList = getAllCategories();
        for(Category category : categoryList){
            System.out.println("category["+ category + "]");
        }
        model.addAttribute("category", categoryList);
        return "schedule/sortCategory";
    }

    //토토영 참고!
    @PostMapping("/api/category")
    public String sendCate(Model model, @RequestParam("cate") String cateName){
        System.out.println(cateName);
        model.addAttribute("cateName", cateName);
        return "schedule/saveForm";
    }

    //build get all category REST API
    @GetMapping("/api/categories")
    public List<Category> getAllCategories(){
        return scheduleService.getAllCategories();
    }


    //스케줄 상세 화면 랜더링
    @GetMapping("/details/{id}")
    public String Details(@PathVariable Long id, Model model){
        model.addAttribute("schedule", scheduleService.scheduleDetail(id));
        return "schedule/details";
    }

    //마이스케줄
    @GetMapping("/myList")
    public String MyList(){
        return "user/myList";
    }

    //하트 스케줄함
    @GetMapping("/myHeartList")
<<<<<<< Updated upstream
    public String MyHeartList(Model model, @PageableDefault(size = 12,sort = "schedule.likeCount", direction = Sort.Direction.DESC)Pageable pageable,
                              @AuthenticationPrincipal PrincipalDetail principal){
        Page<UserLike> userLikes = scheduleService.heartScheduleSelect(pageable, principal.getUser().getUser_id());
        model.addAttribute("userLikes", userLikes);
=======
    public String MyHeartList(){
>>>>>>> Stashed changes
        return "user/myHeartList";
    }

    @PostMapping("/api/category")
    public String category(@RequestParam("cate") String categ, ModelMap model, HttpServletRequest request){
//        String reqCate = request.getParameter("cate");
        System.out.println("categ["+categ+"]");
        String req = request.getParameter("cate");
        model.addAttribute("category", req);
        return "/schedule/saveForm";
    }

}
