package com.example.fundraisingapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Contribution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    
    @Column
    @NonNull
    private int projectId;
    
    @Column
    @NonNull
    private String contributorEmail;
    
    @Column
    @NonNull
    private int amountGiven;
    
    @Column
    @NonNull
    private String projectName;
}
