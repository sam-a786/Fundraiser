package com.example.fundraisingapp;

import com.example.fundraisingapp.model.*;
import com.example.fundraisingapp.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class FundraisingappApplicationTests {
    
    @Autowired
    private ContributionsDao contributionsDao;
    
    @Autowired
    private FundSeekerDao fundSeekerDao;
    
    @Autowired
    private FundContributorDao fundContributorDao;
    
    @Autowired
    private ProjectsDao projectsDao;
    
    @Autowired
    private PlatformOwnerDao platformOwnerDao;
    
    @Test
    void contextLoads() {
    
    }
    
    @Test
    void testContributionEntity() {
        Contribution contribution = new Contribution(1, "c1@gmail.com", 0, "project one");
        assertEquals(1, contribution.getProjectId());
    }
    
    @Test
    void testFundContributorEntity() {
        FundContributor fundContributor = new FundContributor("contributor100", "contributor100@gmail.com", "password", BigInteger.valueOf(111111111), 1000);
        assertEquals("contributor100", fundContributor.getContactName());
    }
    
    @Test
    void testFundSeekerEntity() {
        FundSeeker fundSeeker = new FundSeeker("seeker100", "seeker100@gmail.com", "password12345", BigInteger.valueOf(111111111));
        assertEquals("seeker100", fundSeeker.getContactName());
    }
    
    @Test
    void testPlatformOwnerEntity() {
        PlatformOwner platformOwner = new PlatformOwner("owner", "owner100@gmail.com","password");
        assertEquals("owner100@gmail.com", platformOwner.getEmail());
    }
    
    @Test
    void testProjectsEntity() {
        Projects project = new Projects("project one", 1000, "22 aug 22", "to help people", "s1@gmail.com", new ArrayList<>(), "india");
        assertEquals("project one", project.getName());
    }
    
    @Test
    void testContributionRepo() {
        Contribution contribution = new Contribution(1, "c1@gmail.com", 0, "project one");
        contributionsDao.save(contribution);
        ArrayList<Contribution> list = new ArrayList<>();
        list.add(contribution);
        Assertions.assertEquals(list, contributionsDao.findAll());
    }
    
    @Test
    void testFundContributorRepo() {
        FundContributor fundContributor = new FundContributor("contributor100", "contributor100@gmail.com", "password", BigInteger.valueOf(111111111), 1000);
        fundContributorDao.save(fundContributor);
        assertEquals(fundContributor, fundContributorDao.findByEmail("contributor100@gmail.com"));
    }
    
    @Test
    void testFundSeekerRepo() {
        FundSeeker fundSeeker = new FundSeeker("seeker100", "seeker100@gmail.com", "password12345", BigInteger.valueOf(111111111));
        fundSeekerDao.save(fundSeeker);
        assertEquals(fundSeeker, fundSeekerDao.findByEmail("seeker100@gmail.com"));
    }
    
    @Test
    void testPlatformOwnerRepo() {
        assertEquals(1, platformOwnerDao.count());
    }
    
    @Test
    void testProjectsRepo() {
        Projects project = new Projects("project one", 1000, "22 aug 22", "to help people", "s1@gmail.com", new ArrayList<>(), "india");
        projectsDao.save(project);
        Assertions.assertEquals(1, projectsDao.count());
    }
}