package com.att.tdp.popcorn_palace.controllers;

import com.att.tdp.popcorn_palace.dtos.MovieDTO;
import com.att.tdp.popcorn_palace.models.Movie;
import com.att.tdp.popcorn_palace.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Get all movies from the database.
     *
     * @return a ResponseEntity containing a list of all movies.
     */
    @GetMapping("/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        List<MovieDTO> movieDTOs = movies.stream().map(MovieDTO::new).toList();

        return ResponseEntity.ok(movieDTOs);
    }

    /**
     * Add a movie to the database.
     * @param movie a movie to add.
     * @return a ResponseEntity containing the new movie.
     */
    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody Movie movie) {
        Movie returnedMovie = movieService.addMovie(movie);

        if (returnedMovie == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(new MovieDTO(returnedMovie));
    }

    /**
     * Update some information about a movie in the database.
     * @param movieTitle the title of the movie to update.
     * @param updates the fields to update and their new values.
     * @return a ResponseEntity containing the updated movie.
     */
    @PostMapping("/update/{movieTitle}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable String movieTitle, @RequestBody MovieDTO updates) {
        Movie returnedMovie = movieService.updateMovieByTitle(movieTitle, updates);

        if (returnedMovie == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new MovieDTO(returnedMovie));
    }

    /**
     * Deletes a movie from the database.
     *
     * @param movieTitle the title of the movie to delete.
     * @return a ResponseEntity with no content upon successful deletion.
     */
    @DeleteMapping("/{movieTitle}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movieTitle) {
        if (!movieService.deleteMovieByTitle(movieTitle)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}