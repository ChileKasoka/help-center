package com.example.help.center.cleaner.service;

import java.util.List;

import com.example.help.center.cleaner.entity.Cleaner;

public interface CleanerService {
    void addCleaner(Cleaner cleaner);
    Cleaner getCleanerById(Long id);
    List<Cleaner> getAllCleanersByCompany(Long companyId);
    void updateCleaner(Cleaner cleaner);
    void deleteCleaner(Long id);
}

