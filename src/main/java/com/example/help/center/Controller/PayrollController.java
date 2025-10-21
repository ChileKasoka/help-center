package com.example.help.center.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.Service.PayrollService;
import com.example.help.center.entity.Payroll;

import java.util.List;

@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {

    private final PayrollService payrollService;

    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @GetMapping
    public ResponseEntity<List<Payroll>> getAllPayrolls(@PathVariable Long companyId) {
        return ResponseEntity.ok(payrollService.getPayrollsByCompany(companyId));
    }

    @PostMapping
    public ResponseEntity<String> createPayroll(@RequestBody Payroll payroll) {
        payrollService.createPayroll(payroll);
        return ResponseEntity.ok("Payroll created successfully");
    }
}
