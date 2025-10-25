package com.example.help.center.cleaner.entity;

import java.util.List;

import com.example.help.center.booking.entity.Booking;
import com.example.help.center.company.entity.Company;
import com.example.help.center.wallet.entity.Wallet;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "cleaners")
public class Cleaner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String f_name;
    private String l_name;
    private String phone;
    private String nationalId;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private String latitude;
    private String longitude;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    // Work Relationship
    @OneToMany(mappedBy = "cleaner")
    private List<Booking> bookings;

    @OneToOne(mappedBy = "cleaner")
    private Wallet wallet;

    @Builder.Default
    private Boolean isAvailable = true;
}

