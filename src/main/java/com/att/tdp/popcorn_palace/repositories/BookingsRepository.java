package com.att.tdp.popcorn_palace.repositories;

import com.att.tdp.popcorn_palace.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    
}
