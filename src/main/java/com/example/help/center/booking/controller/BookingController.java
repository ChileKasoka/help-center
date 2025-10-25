package com.example.help.center.booking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.booking.entity.Booking;
import com.example.help.center.booking.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(@PathVariable Long companyId) {
        return ResponseEntity.ok(bookingService.getAllBookingsByCompany(companyId));
    }

    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return ResponseEntity.ok("Booking created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBooking(@PathVariable Long id, @RequestBody Booking booking) {
        booking.setId(id);
        bookingService.updateBooking(booking);
        return ResponseEntity.ok("Booking updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
