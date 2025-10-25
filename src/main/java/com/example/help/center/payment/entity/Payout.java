package com.example.help.center.payment.entity;

import java.time.LocalDateTime;

import com.example.help.center.company.entity.Company;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "payouts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    private Double amount;
    private LocalDateTime paidAt;

    private String reference; // booking reference
}
