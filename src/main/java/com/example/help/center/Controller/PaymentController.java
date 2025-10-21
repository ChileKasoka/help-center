package com.example.help.center.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.Service.PaymentService;
import com.example.help.center.entity.Payment;

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
