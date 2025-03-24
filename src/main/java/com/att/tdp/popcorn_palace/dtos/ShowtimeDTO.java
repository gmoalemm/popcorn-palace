package com.att.tdp.popcorn_palace.dtos;
import com.att.tdp.popcorn_palace.models.Showtime;

import java.time.LocalDateTime;

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
        this.movieId = showtime.getMovieId();
        this.theater = showtime.getTheater();
        this.startTime = showtime.getStartTime();
        this.endTime = showtime.getEndTime();
    }
}