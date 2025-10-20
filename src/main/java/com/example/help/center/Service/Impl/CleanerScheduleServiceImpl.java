package com.example.help.center.Service.Impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.help.center.Repository.CleanerScheduleRepository;
import com.example.help.center.Service.CleanerScheduleService;
import com.example.help.center.entity.CleanerSchedule;

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
