package com.example.help.center.cleaner.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.cleaner.entity.Cleaner;
import com.example.help.center.cleaner.service.CleanerService;

import java.util.List;

@RestController
@RequestMapping("/api/cleaners")
public class CleanerController {

    private final CleanerService cleanerService;

    public CleanerController(CleanerService cleanerService) {
        this.cleanerService = cleanerService;
    }

    @GetMapping
    public ResponseEntity<List<Cleaner>> getAllCleaners(@PathVariable Long companyId) {
        return ResponseEntity.ok(cleanerService.getAllCleanersByCompany(companyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cleaner> getCleanerById(@PathVariable Long id) {
        return ResponseEntity.ok(cleanerService.getCleanerById(id));
    }

    @PostMapping
    public ResponseEntity<String> createCleaner(@RequestBody Cleaner cleaner) {
        cleanerService.addCleaner(cleaner);
        return ResponseEntity.ok("Cleaner added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCleaner(@PathVariable Long id, @RequestBody Cleaner cleaner) {
        cleaner.setId(id);
        cleanerService.updateCleaner(cleaner);
        return ResponseEntity.ok("Cleaner updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCleaner(@PathVariable Long id) {
        cleanerService.deleteCleaner(id);
        return ResponseEntity.ok("Cleaner deleted successfully");
    }
}
