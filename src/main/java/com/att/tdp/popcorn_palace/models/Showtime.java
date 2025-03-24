package com.att.tdp.popcorn_palace.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Showtime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_showtime_movie"))
    private Movie movie;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private String theater;

    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;

    @Column(nullable = false, name = "end_time")
    private LocalDateTime endTime;
}
