package com.example.help.center.Service;

import com.example.help.center.entity.Booking;
import java.util.List;

public interface BookingService {
    void createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookingsByCompany(Long companyId);
    void updateBooking(Booking booking);
    void deleteBooking(Long id);
}

