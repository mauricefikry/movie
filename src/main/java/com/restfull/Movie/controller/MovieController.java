package com.restfull.Movie.controller;


import com.restfull.Movie.model.request.MovieCreateRequest;
import com.restfull.Movie.model.request.MovieUpdateRequest;
import com.restfull.Movie.model.response.ApiResponse;
import com.restfull.Movie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllMovies(
    ) {
        return movieService.getAllMovies();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> getMovieDetail(
            @PathVariable(value = "id") Integer id
    ) {
        return movieService.getMovieDetail(id);
    }

    @PostMapping()
    public ResponseEntity<ApiResponse> addMovie(
            @Valid @RequestBody MovieCreateRequest request
    ) {
        return movieService.addMovie(request);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> updateMovie(
            @Valid @RequestBody MovieUpdateRequest request,
            @PathVariable(value = "id") Integer id
    ) {
        return movieService.updateMovie(id, request);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse> deleteMovie(
            @PathVariable(value = "id") Integer id
    ) {
        return movieService.deleteMovie(id);
    }

}
