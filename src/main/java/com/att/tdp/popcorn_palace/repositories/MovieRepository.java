package com.att.tdp.popcorn_palace.repositories;

import com.att.tdp.popcorn_palace.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /**
     * Finds a movie by its title.
     *
     * @param title the title of the movie to find
     * @return an Optional containing the found movie, or an empty Optional if no movie is found with the given title.
     */
    Optional<Movie> findByTitle(String title);

    /**
     * Deletes a movie from the database by its title.
     *
     * @param title the title of the movie to delete.
     */
    void deleteByTitle(String title);
}
