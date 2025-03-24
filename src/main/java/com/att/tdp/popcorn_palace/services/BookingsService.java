package com.att.tdp.popcorn_palace.services;

import com.att.tdp.popcorn_palace.models.Booking;
import com.att.tdp.popcorn_palace.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {

    @Autowired
    private BookingsRepository bookingsRepository;

    /**
     * Add a booking to the database.
     * @param booking a booking to add.
     * @return the added booking's ID.
     */
    public Booking addBooking(Booking booking) {
        return bookingsRepository.save(booking);
    }

}