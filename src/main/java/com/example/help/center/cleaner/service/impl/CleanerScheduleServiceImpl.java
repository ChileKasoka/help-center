package com.example.help.center.cleaner.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.help.center.cleaner.entity.CleanerSchedule;
import com.example.help.center.cleaner.repository.CleanerScheduleRepository;
import com.example.help.center.cleaner.service.CleanerScheduleService;

import java.util.List;

@Service
@Transactional
public class CleanerScheduleServiceImpl implements CleanerScheduleService {

    private final CleanerScheduleRepository mapper;

    public CleanerScheduleServiceImpl(CleanerScheduleRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createSchedule(CleanerSchedule schedule) {
        mapper.insert(schedule);
    }

    @Override
    public CleanerSchedule getScheduleById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<CleanerSchedule> getSchedulesByCleaner(Long cleanerId) {
        return mapper.findByCleanerId(cleanerId);
    }

    @Override
    public void updateSchedule(CleanerSchedule schedule) {
        mapper.update(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        mapper.delete(id);
    }
}
