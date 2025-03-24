package com.att.tdp.popcorn_palace.controllers;

import com.att.tdp.popcorn_palace.models.Showtime;
import com.att.tdp.popcorn_palace.services.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {

    @Autowired
    private ShowtimeService showtimeService;

    // GET: Fetch a showtime by id
    @GetMapping("/{showtimeId}")
    public ResponseEntity<Optional<Showtime>> getShowtime(@PathVariable Long id) {
        return ResponseEntity.ok(showtimeService.getShowtime(id));
    }

    // POST: Add a new movie
    @PostMapping
    public ResponseEntity<Showtime> addShowtime(@RequestBody Showtime showtime) {
        return ResponseEntity.ok(showtimeService.addShowtime(showtime));
    }

    // POST: Update an existing movie by title
    @PostMapping("/update/{showtimeId}")
    public ResponseEntity<Showtime> updateMovie(@PathVariable Long showtimeId, @RequestBody Showtime movie) {
        return ResponseEntity.ok(showtimeService.updateShowtimeById(showtimeId, movie));
    }

    // DELETE: Delete a movie by title
    @DeleteMapping("/{showtimeId}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long showtimeId) {
        showtimeService.deleteShowtimeByTitle(showtimeId);
        return ResponseEntity.ok().build();
    }
}