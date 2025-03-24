package com.att.tdp.popcorn_palace.repos;

import com.att.tdp.popcorn_palace.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepo extends JpaRepository<Movie, Long> {

    // Custom query to find a movie by title
    Optional<Movie> findByTitle(String title);

    // Custom query to delete a movie by title
    void deleteByTitle(String title);
}
