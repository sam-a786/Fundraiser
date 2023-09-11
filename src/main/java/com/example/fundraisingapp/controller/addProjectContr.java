package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class addProjectContr {
    
    @Autowired
    private ProjectsService projectsService;
    
    @PostMapping("/fund-seeker/add/project")
    public ResponseEntity<?> addProject(
            @RequestParam String projectName,
            @RequestParam String projectPurpose,
            @RequestParam int projectTargetAmount,
            @RequestParam String projectTargetDate,
            @RequestParam String email,
            @RequestParam String projectLocation
    ) {
        projectsService.addProject(
                projectName,
                projectTargetAmount,
                projectTargetDate,
                projectPurpose,
                email,
                projectLocation
        );
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
