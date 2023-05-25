package com.restfull.Movie.service;

import com.restfull.Movie.entity.Movie;
import com.restfull.Movie.model.request.MovieCreateRequest;
import com.restfull.Movie.model.request.MovieUpdateRequest;
import com.restfull.Movie.model.response.ApiResponse;
import com.restfull.Movie.repository.MovieRep;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import java.util.Objects;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Slf4j
public class MovieServiceTest {

    @Autowired
    MovieRep movieRep;

    @Autowired
    MovieService movieService;

    Movie movieExpectedData;

    @BeforeAll
    public void setup() {

        Movie movie = new Movie();
        movie.setTitle("Pengabdi Setan New");
        movie.setDescription("Pengabdi Setan Deskripsi New");
        movie.setRating(10.0);
        movie.setImage("pengabdi-setan-new.jpg");
        movieExpectedData = movie;

    }

    @Test
    public void testCreateMovie() {

        MovieCreateRequest movieCreateRequest = new MovieCreateRequest();
        movieCreateRequest.setTitle("Pengabdi setan");
        movieCreateRequest.setDescription("Pengabdi Setan Deskripsi");
        movieCreateRequest.setRating(10.0);
        movieCreateRequest.setImage("pengabdi-setan.jpg");
        ResponseEntity<ApiResponse> createMovieService = movieService.addMovie(movieCreateRequest);
        Assertions.assertEquals(
                "Success Created Movie",
                Objects.requireNonNull(createMovieService.getBody()).getMessage());
        Assertions.assertEquals(
                true, Objects.requireNonNull(createMovieService.getBody()).getSuccess());
    }

    @Test
    public void testUpdateMovie() {

        MovieUpdateRequest movieUpdateRequest = new MovieUpdateRequest();
        movieUpdateRequest.setTitle("Pengabdi Setan New");
        movieUpdateRequest.setDescription("Pengabdi Setan Deskripsi New");
        movieUpdateRequest.setRating(10.0);
        movieUpdateRequest.setImage("pengabdi-setan-new.jpg");
        ResponseEntity<ApiResponse> updateMovie = movieService.updateMovie(8, movieUpdateRequest);
        Assertions.assertEquals(
                "Success Updated Movie",
                Objects.requireNonNull(updateMovie.getBody()).getMessage());
        Assertions.assertEquals(
                true, Objects.requireNonNull(updateMovie.getBody()).getSuccess());
    }

    @Test
    public void testUpdateNotFoundIdMovie() {

        MovieUpdateRequest movieUpdateRequest = new MovieUpdateRequest();
        movieUpdateRequest.setTitle("Pengabdi Setan New");
        movieUpdateRequest.setDescription("Pengabdi Setan Deskripsi New");
        movieUpdateRequest.setRating(10.0);
        movieUpdateRequest.setImage("pengabdi-setan-new.jpg");
        ResponseEntity<ApiResponse> updateMovie = movieService.updateMovie(1, movieUpdateRequest);
        Assertions.assertEquals(
                "Failed Updated Movie Detail Because Movie Id Not Found",
                Objects.requireNonNull(updateMovie.getBody()).getMessage());
        Assertions.assertEquals(
                false, Objects.requireNonNull(updateMovie.getBody()).getSuccess());
    }

    @Test
    public void testDeleteMovie() {

        ResponseEntity<ApiResponse> deleteMovie = movieService.deleteMovie(17);
        Assertions.assertEquals(
                "Success Deleted Movie",
                Objects.requireNonNull(deleteMovie.getBody()).getMessage());
        Assertions.assertEquals(
                true, Objects.requireNonNull(deleteMovie.getBody()).getSuccess());
    }

    @Test
    public void testDeleteNotFoundIdMovie() {

        ResponseEntity<ApiResponse> deleteMovie = movieService.deleteMovie(100);
        Assertions.assertEquals(
                "Failed Delete Movie Detail Because Movie Id Not Found",
                Objects.requireNonNull(deleteMovie.getBody()).getMessage());
        Assertions.assertEquals(
                false, Objects.requireNonNull(deleteMovie.getBody()).getSuccess());
    }


    @Test
    public void testGetMovieDetail() {

        ResponseEntity<ApiResponse> findMovieDetail = movieService.getMovieDetail(8);
        Assertions.assertEquals(
                "Success Get Movie Detail",
                Objects.requireNonNull(findMovieDetail.getBody()).getMessage());
        Assertions.assertEquals(
                true, Objects.requireNonNull(findMovieDetail.getBody()).getSuccess());
    }

    @Test
    public void testGetAllMovies() {

        ResponseEntity<ApiResponse> findAllMovie = movieService.getAllMovies();
        Assertions.assertEquals(
                "Success Get All Movies",
                Objects.requireNonNull(findAllMovie.getBody()).getMessage());
        Assertions.assertEquals(
                true, Objects.requireNonNull(findAllMovie.getBody()).getSuccess());
    }


}
