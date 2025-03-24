package com.att.tdp.popcorn_palace.controllers;

import com.att.tdp.popcorn_palace.dtos.BookingDTO;
import com.att.tdp.popcorn_palace.models.Booking;
import com.att.tdp.popcorn_palace.services.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingsService bookingsService;

    /**
     * Adds a new ticket to the database.
     *
     * @param booking a booking to add.
     * @return a ResponseEntity containing the booking ID.
     */
    @PostMapping
    public ResponseEntity<BookingDTO> addBooking(@RequestBody Booking booking) {
        Booking returnedBooking = bookingsService.addBooking(booking);
        BookingDTO bookingDTO = new BookingDTO(returnedBooking);
        return ResponseEntity.ok(bookingDTO);
    }
}