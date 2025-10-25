package com.example.help.center.cleaner.entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data
@Entity
@Table(name = "cleaner_schedules")
public class CleanerSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Boolean isBooked = false;

    @ManyToOne
    @JoinColumn(name = "cleaner_id")
    private Cleaner cleaner;
}

