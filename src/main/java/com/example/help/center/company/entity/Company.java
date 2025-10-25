package com.example.help.center.company.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.example.help.center.auth.entity.User;
import com.example.help.center.booking.entity.Booking;
import com.example.help.center.cleaner.entity.Cleaner;
import com.example.help.center.cleanerServices.entity.Service;
import com.example.help.center.wallet.entity.Wallet;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tenant metadata
    private String name;
    private String registrationNumber; // optional: PACRA or business license
    private String email;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private CompanyStatus status; // ACTIVE, SUSPENDED, CLOSED

    // Subscription / Revenue tracking
    private Double revenueSharePercentage; // e.g. app takes 10% per booking
    // private LocalDate subscriptionStart;
    // private LocalDate subscriptionEnd;

    // Admin user for this company (owner/manager)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Relations
    @OneToMany(mappedBy = "company")
    private List<Cleaner> cleaners;

    @OneToMany(mappedBy = "company")
    private List<Service> services;

    @OneToMany(mappedBy = "company")
    private List<Booking> bookings;

    @OneToOne(mappedBy = "company")
    private Wallet wallet;
}
