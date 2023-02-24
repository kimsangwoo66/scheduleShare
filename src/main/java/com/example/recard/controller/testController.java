package com.example.recard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/test")
    public String test(){

        /*
        * spring.mvc.view.prefix=/WEB-INF/views/
        * spring.mvc.view.suffix=.jsp 로 application.properties에 설정
        * 따라서 return "test" 일경우 실제 /WEB-INF/views/test.jsp를 의미
        * */
        return "test";
    }




}
