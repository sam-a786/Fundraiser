package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FundSeekerController {
    
    @Autowired
    private FundSeekerService fundSeekerService;
    
    @GetMapping("/fund-seeker/home")
    public String getHome(
            Model model,
            @RequestParam String email
    ) {
        model.addAttribute("user", fundSeekerService.findUser(email));
        return "fundSeeker";
    }
    
    @GetMapping("/fund-seeker/dashboard")
    public String getDashboard(
            Model model,
            @RequestParam String email
    ) {
        model.addAttribute("user", fundSeekerService.findUser(email));
        model.addAttribute("fundContributors", fundSeekerService.getProjectsContributions(email));
        model.addAttribute("pendingProjects", fundSeekerService.getPendingProjects(email));
        model.addAttribute("completedProjects", fundSeekerService.getCompletedProjects(email));
        return "FundSeekerDashboard";
    }
}
