package com.example.fundraisingapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Projects {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    
    @Column
    @NonNull
    private String name;
    
    @Column
    @NonNull
    private int targetAmount;
    
    @Column
    @NonNull
    private String targetDate;
    
    @Column
    @NonNull
    private String projectPurpose;
    
    @Column
    @NonNull
    private String fundSeekerEmail;
    
    @Column
    @NonNull
    @ElementCollection
    private List<String> fundContributorsEmail;
    
    @Column
    @NonNull
    private String location;
    
    @Column
    private int fundsGiven;
}