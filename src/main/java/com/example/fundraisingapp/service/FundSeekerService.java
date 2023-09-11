package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.Contribution;
import com.example.fundraisingapp.model.FundSeeker;
import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.ContributionsDao;
import com.example.fundraisingapp.repository.FundSeekerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FundSeekerService {
    
    @Autowired
    private FundSeekerDao fundSeekerDao;
    
    @Autowired
    private ContributionsDao contributionsDao;
    
    public boolean authenticate(String email, String password) {
        boolean userExists = false;
        for (FundSeeker seeker : fundSeekerDao.findAll()) {
            if (seeker.getEmail().equals(email)
                    && seeker.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }
        return userExists;
    }
    
    public FundSeeker findUser(String email) {
        return fundSeekerDao.findByEmail(email);
    }
    
    public void register(
        String contactName, String email, String password, BigInteger bankCard
    ) {
        fundSeekerDao.save(new FundSeeker(contactName, email, password, bankCard));
    }
    
    public List<Contribution> getProjectsContributions(String projectCreatorEmail) {
        List<Projects> projects = fundSeekerDao.getProjects(projectCreatorEmail);
        List<Contribution> contributions = new ArrayList<>();
        for (Projects project : projects) {
            contributions.addAll(contributionsDao.getContributionsByProjectId(project.getId()));
        }
       return contributions;
    }
    
    public int getPendingProjects(String email) {
        List<Projects> projects = fundSeekerDao.getProjects(email);
        int pendingProjects = 0;
        for (Projects project : projects) {
            if (project.getTargetAmount() > project.getFundsGiven()) {
                pendingProjects++;
            }
        }
        return pendingProjects;
    }
    
    public int getCompletedProjects(String email) {
        List<Projects> projects = fundSeekerDao.getProjects(email);
        int completedProjects = 0;
        for (Projects project : projects) {
            if (project.getTargetAmount() <= project.getFundsGiven()) {
                completedProjects++;
            }
        }
        return completedProjects;
    }
}
