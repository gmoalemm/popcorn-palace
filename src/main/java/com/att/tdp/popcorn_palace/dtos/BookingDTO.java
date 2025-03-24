package com.att.tdp.popcorn_palace.dtos;
import com.att.tdp.popcorn_palace.models.Booking;

import java.util.UUID;

public class BookingDTO {
    private final UUID id;
    private final Long showtimeId;
    private final Integer seatNumber;
    private final UUID userId;

    public BookingDTO(Booking booking) {
        this.id = booking.getId();
        this.showtimeId = booking.getShowtime().getId();
        this.seatNumber = booking.getSeatNumber();
        this.userId = booking.getUserId();
    }
}