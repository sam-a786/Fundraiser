package com.example.fundraisingapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class getSignupPageContr {
    
    @GetMapping("/user/signup")
    public String getSignupPage() {
        return "signup";
    }
}
