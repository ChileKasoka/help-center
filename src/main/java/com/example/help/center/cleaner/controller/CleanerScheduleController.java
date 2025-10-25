package com.example.help.center.cleaner.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.cleaner.entity.CleanerSchedule;
import com.example.help.center.cleaner.service.CleanerScheduleService;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class CleanerScheduleController {

    private final CleanerScheduleService scheduleService;

    public CleanerScheduleController(CleanerScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping
    public ResponseEntity<List<CleanerSchedule>> getAllSchedules(@PathVariable Long cleanerId) {
        return ResponseEntity.ok(scheduleService.getSchedulesByCleaner(cleanerId));
    }

    @PostMapping
    public ResponseEntity<String> createSchedule(@RequestBody CleanerSchedule schedule) {
        scheduleService.createSchedule(schedule);
        return ResponseEntity.ok("Schedule created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id, @RequestBody CleanerSchedule schedule) {
        schedule.setId(id);
        scheduleService.updateSchedule(schedule);
        return ResponseEntity.ok("Schedule updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.ok("Schedule deleted successfully");
    }
}
