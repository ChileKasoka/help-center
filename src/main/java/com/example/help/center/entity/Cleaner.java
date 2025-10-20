package com.example.help.center.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cleaners")
public class Cleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String f_name;
    private String l_name;
    private String phone;
    private String nationalId;
    private String gender;
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    private Boolean isAvailable = true;
}

