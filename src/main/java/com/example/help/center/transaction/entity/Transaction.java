package com.example.help.center.transaction.entity;

import java.time.LocalDateTime;


import com.example.help.center.payment.entity.PaymentMethod;
import com.example.help.center.wallet.entity.Wallet;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Wallet wallet;

    private Double amount;
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; // CREDIT, DEBIT

    private String reference; // booking ID or payment ID
}
