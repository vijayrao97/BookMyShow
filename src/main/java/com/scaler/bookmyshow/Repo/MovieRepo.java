package com.scaler.bookmyshow.Repo;

import com.scaler.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    Movie save(Movie m);
}
