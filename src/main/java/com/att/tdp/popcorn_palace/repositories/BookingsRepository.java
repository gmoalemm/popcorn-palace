package com.att.tdp.popcorn_palace.repositories;

import com.att.tdp.popcorn_palace.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<Booking, Long> {

}
