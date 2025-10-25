package com.example.help.center.payment.service;

import java.util.List;

import com.example.help.center.payment.entity.Payment;

public interface PaymentService {
    void addPayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsByCompany(Long companyId);
    void updatePayment(Payment payment);
    void deletePayment(Long id);
}
