package com.restfull.Movie.repository;

import com.restfull.Movie.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRep extends JpaRepository<Movie, Integer> {
}
