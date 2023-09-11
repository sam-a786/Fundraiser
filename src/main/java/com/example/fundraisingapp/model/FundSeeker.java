package com.example.fundraisingapp.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class FundSeeker {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    
    @Column
    @NonNull
    private String contactName;
    
    @Column(unique = true)
    @NonNull
    private String email;
    
    @Column
    @NonNull
    private String password;
    
    @NonNull
    @Column
    private BigInteger bankCard;
}
