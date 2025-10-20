package com.example.help.center.Service;

import com.example.help.center.entity.Cleaner;
import java.util.List;

public interface CleanerService {
    void addCleaner(Cleaner cleaner);
    Cleaner getCleanerById(Long id);
    List<Cleaner> getAllCleanersByCompany(Long companyId);
    void updateCleaner(Cleaner cleaner);
    void deleteCleaner(Long id);
}

