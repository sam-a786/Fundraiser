package com.example.fundraisingapp.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class PlatformOwner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int id;
    
    @Column
    @NonNull
    private String username;
    
    @Column(unique = true)
    @NonNull
    private String email;
    
    @Column
    @NonNull
    private String password;
}
