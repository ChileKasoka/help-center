package com.example.help.center.cleaner.service;


import java.util.List;

import com.example.help.center.cleaner.entity.CleanerSchedule;

public interface CleanerScheduleService {
    void createSchedule(CleanerSchedule schedule);
    CleanerSchedule getScheduleById(Long id);
    List<CleanerSchedule> getSchedulesByCleaner(Long cleanerId);
    void updateSchedule(CleanerSchedule schedule);
    void deleteSchedule(Long id);
}

