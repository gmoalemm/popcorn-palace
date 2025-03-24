package com.att.tdp.popcorn_palace.services;

import com.att.tdp.popcorn_palace.dtos.ShowtimeDTO;
import com.att.tdp.popcorn_palace.models.Movie;
import com.att.tdp.popcorn_palace.models.Showtime;
import com.att.tdp.popcorn_palace.repositories.MovieRepository;
import com.att.tdp.popcorn_palace.repositories.ShowtimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowtimeService {

    @Autowired
    private ShowtimesRepository showtimesRepository;

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Get a showtime by its unique identifier.
     *
     * @param id the ID of the showtime to get.
     * @return an Optional containing the requested Showtime if found, or an empty Optional if not found.
     */
    public Optional<Showtime> getShowtime(Long id) {
        return showtimesRepository.findById(id);
    }

    /**
     * Add a showtime to the database.
     * @param showtime a showtime to add.
     * @return the added showtime.
     */
    public Showtime addShowtime(Showtime showtime) {
        return showtimesRepository.save(showtime);
    }

    /**
     * Update some information about a showtime in the database.
     * @param id the ID of the showtime to update.
     * @param updates the fields to update and their new values.
     * @return the updated showtime.
     */
    public Showtime updateShowtimeById(Long id, ShowtimeDTO updates) {
        // Find movie by title
        Showtime showtime = showtimesRepository.findById(id).orElse(null);

        if (showtime == null) {
            return null;
        }

        // Update fields

        if (updates.getMovieId() != null) {
            Movie movie = movieRepository.findById(updates.getMovieId()).orElse(null);

            if (movie == null) {
                return null;
            }

            showtime.setMovie(movie);
        }

        if (updates.getPrice() != null) {
            showtime.setPrice(updates.getPrice());
        }

        if (updates.getTheater() != null) {
            showtime.setTheater(updates.getTheater());
        }

        if (updates.getStartTime() != null) {
            showtime.setStartTime(updates.getStartTime());
        }

        if (updates.getEndTime() != null) {
            showtime.setEndTime(updates.getEndTime());
        }

        return showtimesRepository.save(showtime); // Save and return the updated movie
    }

    /**
     * Deletes a showtime from the database.
     *
     * @param id the id of the showtime to delete.
     */
    public boolean deleteShowtimeByTitle(Long id) {
        Showtime showtime = showtimesRepository.findById(id).orElse(null);

        if (showtime != null) {
            showtimesRepository.delete(showtime); // Delete the movie
        }

        return showtime == null;
    }
}