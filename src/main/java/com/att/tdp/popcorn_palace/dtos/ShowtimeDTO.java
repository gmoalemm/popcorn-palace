package com.att.tdp.popcorn_palace.dtos;
import com.att.tdp.popcorn_palace.models.Showtime;
import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowtimeDTO {
    private final Long id;
    private final Float price;
    private final Long movieId;
    private final String theater;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public ShowtimeDTO(Showtime showtime) {
        this.id = showtime.getId();
        this.price = showtime.getPrice();
        this.movieId = showtime.getMovie().getId();
        this.theater = showtime.getTheater();
        this.startTime = showtime.getStartTime();
        this.endTime = showtime.getEndTime();
    }
}