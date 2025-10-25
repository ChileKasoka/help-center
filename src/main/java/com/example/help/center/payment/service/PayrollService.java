package com.example.help.center.payment.service;

import java.util.List;

import com.example.help.center.payment.entity.Payroll;

public interface PayrollService {
    void createPayroll(Payroll payroll);
    Payroll getPayrollById(Long id);
    List<Payroll> getPayrollsByCompany(Long companyId);
    void updatePayroll(Payroll payroll);
    void deletePayroll(Long id);
}
