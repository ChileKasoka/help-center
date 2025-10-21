package com.example.help.center.Service;

import com.example.help.center.entity.Company;
import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Company registerCompany(Company company);
    Optional<Company> getCompanyById(Long id);
    List<Company> getAllCompanies();
    void updateCompany(Company company);
    void deleteCompany(Long id);
}
