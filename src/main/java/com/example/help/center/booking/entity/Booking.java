package com.example.help.center.booking.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.example.help.center.cleaner.entity.Cleaner;
import com.example.help.center.cleanerServices.entity.Service;
import com.example.help.center.client.entity.Client;
import com.example.help.center.company.entity.Company;

import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BookingType bookingType; // ONE_TIME, RECURRING, CONTRACT
    private LocalDateTime bookingDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    private BookingStatus status; // PENDING, CONFIRMED, COMPLETED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "cleaner_id")
    private Cleaner cleaner;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
