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

    /**
     * Get a list of all movies in the database.
     *
     * @return a list containing all movies.
     */
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Add a movie to the database.
     * @param movie a movie to add.
     * @return the added movie.
     */
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     * Update some information about a movie in the database.
     * @param title the title of the movie to update.
     * @param updates the fields to update and their new values.
     * @return the updated movie.
     * @throws RuntimeException if no movie is found with the given title.
     */
    public Movie updateMovieByTitle(String title, Movie updates) {
        // Find movie by title
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found with title: " + title));

        // Update fields

        if (updates.getTitle() != null) {
            movie.setTitle(updates.getTitle());
        }

        if (updates.getGenre() != null) {
            movie.setGenre(updates.getGenre());
        }

        if (updates.getDuration() != null) {
            movie.setDuration(updates.getDuration());
        }

        if (updates.getRating() != null) {
            movie.setRating(updates.getRating());
        }

        if (updates.getReleaseYear() != null) {
            movie.setReleaseYear(updates.getReleaseYear());
        }

        return movieRepository.save(movie); // Save and return the updated movie
    }


    /**
     * Deletes a movie from the database.
     *
     * @param title the title of the movie to delete.
     * @throws RuntimeException if no movie is found with the given title.
     */
    public void deleteMovieByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title)
                .orElseThrow(() -> new RuntimeException("Movie not found with title: " + title));

        movieRepository.delete(movie); // Delete the movie
    }
}