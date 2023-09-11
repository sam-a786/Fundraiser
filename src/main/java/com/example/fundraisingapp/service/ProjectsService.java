package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.ProjectsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectsService {
    
    final private ProjectsDao projectsDao;
    
    @Autowired
    public ProjectsService(ProjectsDao projectsDao) {
        this.projectsDao = projectsDao;
    }
    
    public void addProject(
            String name,
            int targetAmount,
            String targetDate,
            String projectPurpose,
            String fundSeekerEmail,
            String location
    ) {
        projectsDao.save(new Projects(
                name,
                targetAmount,
                targetDate,
                projectPurpose,
                fundSeekerEmail,
                new ArrayList<>(),
                location
                )
        );
    }
    
    public List<Projects> getAllProjects() {
        return new ArrayList<>(projectsDao.findAll());
    }
    
    public List<Projects> getProjects(String projects) {
        return new ArrayList<>(projectsDao.getProjectsByName(projects));
    }
    
    public void addFunds(int funds, int id, String contributorEmail) {
        int oldFunds = projectsDao.getFundsGiven(id);
        projectsDao.updateFunds(oldFunds + funds, id);
//        ArrayList<String> contributors = new ArrayList<>(projectsDao.getContributors(id));
//        contributors.add(contributorEmail);
//        projectsDao.setContributors(contributors, id);
    }
    
}