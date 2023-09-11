package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.FundSeeker;
import com.example.fundraisingapp.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FundSeekerDao extends JpaRepository<FundSeeker, Integer> {
    
    @Query("select fs from FundSeeker fs where fs.email = :email")
    FundSeeker findByEmail(@Param("email") String email);
    
    @Query("select p from Projects p where p.fundSeekerEmail = :email")
    List<Projects> getProjects(@Param("email") String email);
}
