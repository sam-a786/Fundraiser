package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class platformOwnerContr {
    
    @Autowired
    private ProjectsService projectsService;
    
    @GetMapping("/platform-owner/home")
    public String getHome(Model model, @RequestParam String email) {
        model.addAttribute("projects", projectsService.getAllProjects());
        return "platformOwner";
    }
}
