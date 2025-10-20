package com.example.help.center.Service.Impl;

import org.springframework.stereotype.Service;

import com.example.help.center.Repository.BookingRepository;
import com.example.help.center.Service.BookingService;
import com.example.help.center.entity.Booking;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository mapper;

    public BookingServiceImpl(BookingRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createBooking(Booking booking) {
        mapper.insert(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<Booking> getAllBookingsByCompany(Long companyId) {
        return mapper.findByCompanyId(companyId);
    }

    @Override
    public void updateBooking(Booking booking) {
        mapper.update(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        mapper.delete(id);
    }
}
