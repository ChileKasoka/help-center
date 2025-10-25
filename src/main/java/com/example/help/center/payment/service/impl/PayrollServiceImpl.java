package com.example.help.center.payment.service.impl;

import org.springframework.stereotype.Service;

import com.example.help.center.payment.entity.Payroll;
import com.example.help.center.payment.repository.PayrollRepository;
import com.example.help.center.payment.service.PayrollService;

import java.util.List;

@Service
public class PayrollServiceImpl implements PayrollService {

    private final PayrollRepository mapper;

    public PayrollServiceImpl(PayrollRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createPayroll(Payroll payroll) {
        mapper.insert(payroll);
    }

    @Override
    public Payroll getPayrollById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Payroll> getPayrollsByCompany(Long companyId) {
        return mapper.findByCompanyId(companyId);
    }

    @Override
    public void updatePayroll(Payroll payroll) {
        mapper.update(payroll);
    }

    @Override
    public void deletePayroll(Long id) {
        mapper.delete(id);
    }
}
