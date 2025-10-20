package com.example.help.center.Service;
import com.example.help.center.entity.Payroll;
import java.util.List;

public interface PayrollService {
    void createPayroll(Payroll payroll);
    Payroll getPayrollById(Long id);
    List<Payroll> getPayrollsByCompany(Long companyId);
    void updatePayroll(Payroll payroll);
    void deletePayroll(Long id);
}
