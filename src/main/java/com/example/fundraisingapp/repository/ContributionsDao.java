package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContributionsDao extends JpaRepository<Contribution, Integer> {
    
    @Query("select c from Contribution c where c.projectId=:id")
    List<Contribution> getContributionsByProjectId(@Param("id") int id);
}
