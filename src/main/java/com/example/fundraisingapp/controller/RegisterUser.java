package com.example.fundraisingapp.controller;

import com.example.fundraisingapp.service.FundContributorService;
import com.example.fundraisingapp.service.FundSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class RegisterUser {
    
    @Autowired
    private FundSeekerService fundSeekerService;
    
    @Autowired
    private FundContributorService fundContributorService;
    
    @PostMapping("/user/register")
    public ResponseEntity<?> Register(
            @RequestParam String contactName,
            @RequestParam String email,
            @RequestParam BigInteger debitCard,
            @RequestParam String password,
            @RequestParam String userType
    ) {
        try {
            if (userType.equals("fund-seeker")) {
                fundSeekerService.register(contactName, email, password, debitCard);
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else if (userType.equals("fund-contributor")) {
                fundContributorService.register(contactName, email, password, debitCard);
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
