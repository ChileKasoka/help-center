package com.example.help.center.Service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.help.center.Repository.CompanyRepository;
import com.example.help.center.Service.CompanyService;
import com.example.help.center.entity.Company;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository mapper;

    public CompanyServiceImpl(CompanyRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public Company registerCompany(Company company) {
        mapper.insert(company);
        return company;
    }

    @Override
    public Optional<Company> getCompanyById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return mapper.findAll();
    }

    @Override
    public void updateCompany(Company company) {
        mapper.update(company);
    }

    @Override
    public void deleteCompany(Long id) {
        mapper.delete(id);
    }
}
