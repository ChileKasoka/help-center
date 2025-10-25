package com.example.help.center.payment.entity;
import java.time.LocalDate;

import com.example.help.center.cleaner.entity.Cleaner;
import com.example.help.center.company.entity.Company;

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
