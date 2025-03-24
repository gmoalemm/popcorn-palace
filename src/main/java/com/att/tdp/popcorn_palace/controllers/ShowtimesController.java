package com.att.tdp.popcorn_palace.controllers;

import com.att.tdp.popcorn_palace.dtos.ShowtimeDTO;
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
    public ResponseEntity<ShowtimeDTO> getShowtime(@PathVariable Long id) {
        Showtime returnedShowtime = showtimesService.getShowtime(id).orElse(null);

        if (returnedShowtime == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ShowtimeDTO(returnedShowtime));
    }

    /**
     * Adds a new showtime to the database.
     *
     * @param showtime a showtime to add.
     * @return a ResponseEntity containing the new Showtime.
     */
    @PostMapping
    public ResponseEntity<ShowtimeDTO> addShowtime(@RequestBody Showtime showtime) {
        Showtime returnedShowtime = showtimesService.addShowtime(showtime);
        return ResponseEntity.ok(new ShowtimeDTO(returnedShowtime));
    }

    /**
     * Update some information about a showtime in the database.
     * @param showtimeId the ID of the showtime to update.
     * @param updates the fields to update and their new values.
     * @return a ResponseEntity containing the updated showtime.
     */
    @PostMapping("/update/{showtimeId}")
    public ResponseEntity<ShowtimeDTO> updateShowtime(@PathVariable Long showtimeId, @RequestBody ShowtimeDTO updates) {
        Showtime returnedShowtime = showtimesService.updateShowtimeById(showtimeId, updates);
        return ResponseEntity.ok(new ShowtimeDTO(returnedShowtime));
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