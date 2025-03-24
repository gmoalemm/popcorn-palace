package com.att.tdp.popcorn_palace.dtos;
import com.att.tdp.popcorn_palace.models.Movie;

public class MovieDTO {
    private final Long id;
    private final String title;
    private final String genre;
    private final Integer duration;
    private final Float rating;
    private final Integer releaseYear;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.genre = movie.getGenre();
        this.duration = movie.getDuration();
        this.rating = movie.getRating();
        this.releaseYear = movie.getReleaseYear();
    }
}