package com.example.help.center.wallet.entity;

import lombok.Data;

@Data
public class Wallet {
    private Long id;
    private Long userId;
    private Double balance = 0.0;
    private String currency;
    private OwnerType OwnerType;
}
