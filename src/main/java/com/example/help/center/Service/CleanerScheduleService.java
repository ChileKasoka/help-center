package com.example.help.center.Service;

import com.example.help.center.entity.CleanerSchedule;
import java.util.List;

public interface CleanerScheduleService {
    void createSchedule(CleanerSchedule schedule);
    CleanerSchedule getScheduleById(Long id);
    List<CleanerSchedule> getSchedulesByCleaner(Long cleanerId);
    void updateSchedule(CleanerSchedule schedule);
    void deleteSchedule(Long id);
}

