package com.herve.talentbooking.service;

import com.herve.talentbooking.model.Booking;
import com.herve.talentbooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    public Booking updateBooking(Long id, Booking booking) {
        Booking existing = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        existing.setBookingDate(booking.getBookingDate());
        existing.setStatus(booking.getStatus());
        if (booking.getEvent() != null) {
            existing.setEvent(booking.getEvent());
        }
        if (booking.getTalent() != null) {
            existing.setTalent(booking.getTalent());
        }
        return bookingRepository.save(existing);
    }
}