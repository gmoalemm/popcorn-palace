package com.att.tdp.popcorn_palace.controllers;

import com.att.tdp.popcorn_palace.models.Showtime;
import com.att.tdp.popcorn_palace.services.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/showtimes")
public class ShowtimesController {

    @Autowired
    private ShowtimeService showtimesService;

    /**
     * Get a showtime by its ID.
     *
     * @param id the ID of the showtime to get.
     * @return a ResponseEntity containing an Optional of the requested Showtime.
     */
    @GetMapping("/{showtimeId}")
    public ResponseEntity<Optional<Showtime>> getShowtime(@PathVariable Long id) {
        return ResponseEntity.ok(showtimesService.getShowtime(id));
    }

    /**
     * Adds a new showtime to the database.
     *
     * @param showtime a showtime to add.
     * @return a ResponseEntity containing the new Showtime.
     */
    @PostMapping
    public ResponseEntity<Showtime> addShowtime(@RequestBody Showtime showtime) {
        return ResponseEntity.ok(showtimesService.addShowtime(showtime));
    }

    /**
     * Update some information about a showtime in the database.
     * @param showtimeId the ID of the showtime to update.
     * @param updates the fields to update and their new values.
     * @return a ResponseEntity containing the updated shpwtime.
     */
    @PostMapping("/update/{showtimeId}")
    public ResponseEntity<Showtime> updateMovie(@PathVariable Long showtimeId, @RequestBody Showtime updates) {
        return ResponseEntity.ok(showtimesService.updateShowtimeById(showtimeId, updates));
    }

    /**
     * Deletes a showtime from the database.
     *
     * @param showtimeId the ID of the showtime to delete.
     * @return a ResponseEntity with no content upon successful deletion.
     */
    @DeleteMapping("/{showtimeId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long showtimeId) {
        showtimesService.deleteShowtimeByTitle(showtimeId);
        return ResponseEntity.ok().build();
    }
}