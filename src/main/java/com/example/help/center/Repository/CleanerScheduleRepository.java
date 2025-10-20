package com.example.help.center.Repository;

import com.example.help.center.entity.CleanerSchedule;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CleanerScheduleRepository {

    @Insert("""
        INSERT INTO cleaner_schedules (cleaner_id, date, start_time, end_time, is_booked)
        VALUES (#{cleanerId}, #{date}, #{startTime}, #{endTime}, #{isBooked})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(CleanerSchedule schedule);

    @Select("SELECT * FROM cleaner_schedules WHERE id=#{id}")
    CleanerSchedule findById(Long id);

    @Select("SELECT * FROM cleaner_schedules WHERE cleaner_id=#{cleanerId}")
    List<CleanerSchedule> findByCleanerId(Long cleanerId);

    @Update("UPDATE cleaner_schedules SET is_booked=#{isBooked} WHERE id=#{id}")
    void update(CleanerSchedule schedule);

    @Delete("DELETE FROM cleaner_schedules WHERE id=#{id}")
    void delete(Long id);
}
