package com.att.tdp.popcorn_palace.services;

import com.att.tdp.popcorn_palace.models.Movie;
import com.att.tdp.popcorn_palace.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Fetch all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add a new movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Update an existing movie by title
    public Movie updateMovieByTitle(String title, Movie movieDetails) {
        // Find movie by title
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found with title: " + title));

        // Update fields

        if (movieDetails.getTitle() != null) {
            movie.setTitle(movieDetails.getTitle());
        }

        if (movieDetails.getGenre() != null) {
            movie.setGenre(movieDetails.getGenre());
        }

        if (movieDetails.getDuration() != null) {
            movie.setDuration(movieDetails.getDuration());
        }

        if (movieDetails.getRating() != null) {
            movie.setRating(movieDetails.getRating());
        }

        if (movieDetails.getReleaseYear() != null) {
            movie.setReleaseYear(movieDetails.getReleaseYear());
        }

        return movieRepository.save(movie); // Save and return the updated movie
    }

    // Delete a movie by title
    public void deleteMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found with title: " + title));

        movieRepository.delete(movie); // Delete the movie
    }
}