package com.example.help.center.Service.Impl;


import org.springframework.stereotype.Service;

import com.example.help.center.Repository.PaymentRepository;
import com.example.help.center.Service.PaymentService;
import com.example.help.center.entity.Payment;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository mapper;

    public PaymentServiceImpl(PaymentRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addPayment(Payment payment) {
        mapper.insert(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Payment> getPaymentsByCompany(Long companyId) {
        return mapper.findByCompanyId(companyId);
    }

    @Override
    public void updatePayment(Payment payment) {
        mapper.update(payment);
    }

    @Override
    public void deletePayment(Long id) {
        mapper.delete(id);
    }
}
