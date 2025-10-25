package com.example.help.center.payment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.payment.entity.Payment;
import com.example.help.center.payment.service.PaymentService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments(@PathVariable Long companyId) {
        return ResponseEntity.ok(paymentService.getPaymentsByCompany(companyId));
    }

    @PostMapping
    public ResponseEntity<String> createPayment(@RequestBody Payment payment) {
        paymentService.addPayment(payment);
        return ResponseEntity.ok("Payment recorded successfully");
    }
}
