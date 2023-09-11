package com.example.fundraisingapp;

import com.example.fundraisingapp.model.FundContributor;
import com.example.fundraisingapp.model.FundSeeker;
import com.example.fundraisingapp.model.PlatformOwner;
import com.example.fundraisingapp.repository.FundContributorDao;
import com.example.fundraisingapp.repository.FundSeekerDao;
import com.example.fundraisingapp.repository.PlatformOwnerDao;
import com.example.fundraisingapp.repository.ProjectsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class insertStartData {
    
    @Autowired
    private FundContributorDao fundContributorDao;
    
    @Autowired
    private FundSeekerDao fundSeekerDao;
    
    @Autowired
    private ProjectsDao projectsDao;
    
    @Autowired
    private PlatformOwnerDao platformOwnerDao;
    
    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        
        fundSeekerDao.save(new FundSeeker(
                "seeker1",
                "s1@gmail.com",
                "password12345",
                  BigInteger.valueOf(100)
        ));
        fundContributorDao.save(new FundContributor(
                "contributor1",
                "c1@gmail.com",
                "password12345",
                BigInteger.valueOf(101),
                10000
        ));
        platformOwnerDao.save(new PlatformOwner(
                "owner",
                "owner@gmail.com",
                "password12345"
        ));
        
//        for (int i = 1; i < 10; i++) {
//            projectsDao.save(new Projects(
//                    i,
//                    "project " + i,
//                    100 * i,
//                    0
//            ));
//        }
    }
}