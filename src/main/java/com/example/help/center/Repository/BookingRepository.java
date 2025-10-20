package com.example.help.center.Repository;

import com.example.help.center.entity.Booking;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface BookingRepository {

    @Insert("""
        INSERT INTO bookings (booking_date, start_time, end_time, status, 
                              client_id, cleaner_id, service_id, company_id)
        VALUES (#{bookingDate}, #{startTime}, #{endTime}, #{status}, 
                #{clientId}, #{cleanerId}, #{serviceId}, #{companyId})
        RETURNING id
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Booking booking);

    @Select("SELECT * FROM bookings WHERE id=#{id}")
    Booking findById(Long id);

    @Select("SELECT * FROM bookings WHERE company_id=#{companyId}")
    List<Booking> findByCompanyId(Long companyId);

    @Select("SELECT * FROM bookings WHERE cleaner_id=#{cleanerId}")
    List<Booking> findByCleanerId(Long cleanerId);

    @Update("""
        UPDATE bookings SET status=#{status}, start_time=#{startTime}, end_time=#{endTime}
        WHERE id=#{id}
    """)
    void update(Booking booking);

    @Delete("DELETE FROM bookings WHERE id=#{id}")
    void delete(Long id);
}
