package com.example.recard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class userController {

     @GetMapping("/auth/login")
     public String login(){
         return "user/login";
     }

     @GetMapping("/auth/join")
     public String join(){

         return "user/join";
     }

}
