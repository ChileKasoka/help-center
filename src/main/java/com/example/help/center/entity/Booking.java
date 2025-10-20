package com.example.help.center.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

import lombok.Data;

@Data
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime bookingDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

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
