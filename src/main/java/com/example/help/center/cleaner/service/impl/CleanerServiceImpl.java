package com.example.help.center.cleaner.service.impl;


import org.springframework.stereotype.Service;

import com.example.help.center.cleaner.entity.Cleaner;
import com.example.help.center.cleaner.repository.CleanerRepository;
import com.example.help.center.cleaner.service.CleanerService;

import java.util.List;

@Service
public class CleanerServiceImpl implements CleanerService {

    private final CleanerRepository mapper;

    public CleanerServiceImpl(CleanerRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void addCleaner(Cleaner cleaner) {
        mapper.insert(cleaner);
    }

    @Override
    public Cleaner getCleanerById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Cleaner> getAllCleanersByCompany(Long companyId) {
        return mapper.findByCompanyId(companyId);
    }

    @Override
    public void updateCleaner(Cleaner cleaner) {
        mapper.update(cleaner);
    }

    @Override
    public void deleteCleaner(Long id) {
        mapper.delete(id);
    }
}

