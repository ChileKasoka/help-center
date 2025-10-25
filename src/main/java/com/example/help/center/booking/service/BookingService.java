package com.example.help.center.booking.service;

import java.util.List;

import com.example.help.center.booking.entity.Booking;

public interface BookingService {
    void createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookingsByCompany(Long companyId);
    void updateBooking(Booking booking);
    void deleteBooking(Long id);
}

