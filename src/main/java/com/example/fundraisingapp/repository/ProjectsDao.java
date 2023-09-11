package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface ProjectsDao extends JpaRepository<Projects, Integer> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Projects SET fundsGiven = :funds WHERE id = :id")
    void updateFunds(@Param("funds") int funds, @Param("id") int id);
    
    @Query("SELECT u.fundsGiven from Projects u WHERE u.id = :id")
    int getFundsGiven(@Param("id") int id);
    
    @Query("SELECT u from Projects u WHERE u.name = :name")
    List<Projects> getProjectsByName(@Param("name") String name);
    
    @Query("UPDATE Projects SET fundContributorsEmail = :emails where id = :id")
    void setContributors(@Param("emails") ArrayList<String> contributorEmails, @Param("id") int id);
    
}