package com.att.tdp.popcorn_palace.repositories;

import com.att.tdp.popcorn_palace.models.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowtimesRepository extends JpaRepository<Showtime, Long> {

}
