package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundContributorService;
import com.example.fundraisingapp.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FundContributorContr {
    
    @Autowired
    private ProjectsService projectsService;
    
    @Autowired
    private FundContributorService fundContributorService;
    
    @GetMapping("/fund-contributor/home")
    public String getHome(
            Model model,
            @RequestParam String email,
            @RequestParam String projects
    ) {
        if (projects.isEmpty() || projects.equals("all")) {
            model.addAttribute("projects", projectsService.getAllProjects());
        } else {
            model.addAttribute("projects", projectsService.getProjects(projects));
        }
        model.addAttribute("user", fundContributorService.getUser(email));
        return "fundContributor";
    }
}
