package com.example.help.center.payment.entity;

import java.time.LocalDateTime;

import com.example.help.center.booking.entity.Booking;
import com.example.help.center.booking.entity.BookingType;
import com.example.help.center.company.entity.Company;

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

    private PaymentMethod paymentMethod; // MOBILE_MONEY, CREDIT_CARD, DEBIT_CARD
    @Enumerated(EnumType.STRING)
    private BookingType paymentType; // ONE_TIME, RECURRING, CONTRACT

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
