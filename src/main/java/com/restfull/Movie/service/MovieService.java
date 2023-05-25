package com.restfull.Movie.service;

import com.restfull.Movie.model.request.MovieCreateRequest;
import com.restfull.Movie.model.request.MovieUpdateRequest;
import com.restfull.Movie.model.response.ApiResponse;
import com.restfull.Movie.model.response.MovieResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity<ApiResponse> getAllMovies();
    ResponseEntity<ApiResponse> getMovieDetail(Integer id);
    ResponseEntity<ApiResponse> addMovie(MovieCreateRequest request);
    ResponseEntity<ApiResponse> updateMovie(Integer id, MovieUpdateRequest request);
    ResponseEntity<ApiResponse> deleteMovie(Integer id);
}
