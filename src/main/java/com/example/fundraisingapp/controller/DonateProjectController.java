package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundContributorService;
import com.example.fundraisingapp.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DonateProjectController {
    
    @Autowired
    private ProjectsService projectsService;
    
    @Autowired
    private FundContributorService fundContributorService;
    
    @PostMapping("/donate/project")
    public String donate(
            @RequestParam int projectId,
            @RequestParam String email
    ) {
        boolean fundsAvailable = fundContributorService.checkIfFundsAvailable(email);
        if (!fundsAvailable) {
            return "User does not have funds";
        }
        projectsService.addFunds(100, projectId, email);
        fundContributorService.donate(-100, email, projectId);
        return "Funds transferred";
    }
}