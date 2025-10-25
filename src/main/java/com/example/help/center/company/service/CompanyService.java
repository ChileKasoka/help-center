package com.example.help.center.company.service;

import java.util.List;
import java.util.Optional;

import com.example.help.center.company.entity.Company;




public interface CompanyService {
    Company registerCompany(Company company);
    Optional<Company> getCompanyById(Long id);
    List<Company> getAllCompanies();
    void updateCompany(Company company);
    void deleteCompany(Long id);
}
