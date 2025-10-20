package com.example.help.center.Service;

import com.example.help.center.entity.Payment;
import java.util.List;

public interface PaymentService {
    void addPayment(Payment payment);
    Payment getPaymentById(Long id);
    List<Payment> getPaymentsByCompany(Long companyId);
    void updatePayment(Payment payment);
    void deletePayment(Long id);
}
