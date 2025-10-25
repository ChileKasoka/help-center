package com.example.help.center.cleaner.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cleaner_profiles")
public class CleanerProfile {
    private Long id;
    private Long cleanerId;
    private String profilePictureUrl;
    private String bio;
    private String experience;
    private String skills;
    private String languages;
    private Double rating;
    private String certifications;
}
