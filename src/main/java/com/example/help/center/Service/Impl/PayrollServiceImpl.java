package com.example.help.center.Service.Impl;

import org.springframework.stereotype.Service;

import com.example.help.center.Repository.PayrollRepository;
import com.example.help.center.Service.PayrollService;
import com.example.help.center.entity.Payroll;

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
