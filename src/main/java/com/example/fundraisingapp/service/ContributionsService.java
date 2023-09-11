package com.example.fundraisingapp.service;

import com.example.fundraisingapp.model.Contribution;
import com.example.fundraisingapp.repository.ContributionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContributionsService {
    
    @Autowired private ContributionsDao contributionsDao;
    
    public List<Contribution> getContributionsByProjectId(@Param("id") int id) {
        return contributionsDao.getContributionsByProjectId(id);
    }
}
