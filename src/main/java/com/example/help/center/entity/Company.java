package com.example.help.center.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String address;
    private String logoUrl;

    private String status; // ACTIVE, SUSPENDED, PENDING_APPROVAL
    private LocalDate registeredAt;

    @OneToMany(mappedBy = "company")
    private List<User> users;

    
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private SubscriptionPlan subscriptionPlan;

    private LocalDate subscriptionStartDate;
    private LocalDate subscriptionEndDate;
}

