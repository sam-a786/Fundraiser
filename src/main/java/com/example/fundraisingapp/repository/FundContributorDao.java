package com.example.fundraisingapp.repository;

import com.example.fundraisingapp.model.FundContributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FundContributorDao extends JpaRepository<FundContributor, Integer> {
    
    @Query("select u from FundContributor u where u.email = :email")
    FundContributor findByEmail(@Param("email") String email);
    
    @Query("select u.money from FundContributor u where u.email = :email")
    int findUserMoney(@Param("email") String email);
    
    @Modifying
    @Transactional
    @Query("UPDATE FundContributor fc SET fc.money = :money where fc.email= :email")
    void updateUserMoney(@Param("email") String email, @Param("money") int money);
}