package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.Contribution;
import com.example.fundraisingapp.model.FundContributor;
import com.example.fundraisingapp.model.Projects;
import com.example.fundraisingapp.repository.ContributionsDao;
import com.example.fundraisingapp.repository.FundContributorDao;
import com.example.fundraisingapp.repository.ProjectsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class FundContributorService {
    
    @Autowired
    private FundContributorDao fundContributorDao;
    
    @Autowired
    private ContributionsDao contributionsDao;
    
    @Autowired
    private ProjectsDao projectsDao;
    
    public List<FundContributor> getAllFundRaisers() {
        return new ArrayList<FundContributor>(fundContributorDao.findAll());
    }
    
    public FundContributor getUser(String email) {
        return fundContributorDao.findByEmail(email);
    }
    
    public boolean authenticate(String email, String password) {
        boolean userExists = false;
        for (FundContributor raisers : fundContributorDao.findAll()) {
            if (raisers.getEmail().equals(email)
                    && raisers.getPassword().equals(password)) {
                userExists = true;
                break;
            }
        }
        return userExists;
    }
    
    public void updateFunds(int money, String email) {
        int oldMoney = fundContributorDao.findUserMoney(email);
        int newMoney = oldMoney + money;
        fundContributorDao.updateUserMoney(email, newMoney);
    }
    
    public void donate(int money, String email, int projectId) {
        int oldMoney = fundContributorDao.findUserMoney(email);
        int newMoney = oldMoney + money;
        fundContributorDao.updateUserMoney(email, newMoney);
        Projects project = projectsDao.getById(projectId);
        contributionsDao.save(new Contribution(projectId, email, 100, project.getName()));
    }
    
    public boolean checkIfFundsAvailable(String email) {
        int oldMoney = fundContributorDao.findUserMoney(email);
        return oldMoney != 0;
    }
    
    public void register(
            String contactName, String email, String password, BigInteger bankCard
    ) {
        fundContributorDao.save(new FundContributor(contactName, email, password, bankCard, 1000));
    }
}