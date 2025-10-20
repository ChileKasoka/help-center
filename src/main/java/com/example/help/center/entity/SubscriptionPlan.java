package com.example.help.center.entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subscription_plans")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., "Basic", "Premium"
    private Double price;
    private String duration; // e.g., "monthly", "yearly"
    private Integer maxCleaners;
    private Integer maxClients;
}
