package com.example.help.center.Service;

import com.example.help.center.entity.Company;
import java.util.List;

public interface CompanyService {
    Company registerCompany(Company company);
    Company getCompanyById(Long id);
    List<Company> getAllCompanies();
    void updateCompany(Company company);
    void deleteCompany(Long id);
}
