package com.example.help.center.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private LocalDateTime paymentDate;
    private String reference;
    private Boolean confirmed = false;

    private PaymentMethod paymentMethod; // MOBILE_MONEY, BANK, CASH
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType; // BOOKING, SUBSCRIPTION

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
