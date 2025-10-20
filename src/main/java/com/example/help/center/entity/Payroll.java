package com.example.help.center.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "payrolls")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startPeriod;
    private LocalDate endPeriod;
    private Double totalEarnings;

    @ManyToOne
    @JoinColumn(name = "cleaner_id")
    private Cleaner cleaner;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
