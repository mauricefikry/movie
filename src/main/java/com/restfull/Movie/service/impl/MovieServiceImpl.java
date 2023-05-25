package com.restfull.Movie.service.impl;

import com.restfull.Movie.entity.Movie;
import com.restfull.Movie.model.request.MovieCreateRequest;
import com.restfull.Movie.model.request.MovieUpdateRequest;
import com.restfull.Movie.model.response.ApiResponse;
import com.restfull.Movie.model.response.MovieResponse;
import com.restfull.Movie.repository.MovieRep;
import com.restfull.Movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRep movieRep;

    @Override
    public ResponseEntity<ApiResponse> getAllMovies() {

        List<Movie> movies = movieRep.findAll();
        List<MovieResponse> movieResponseList =  movies.stream().map(movie -> {

            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setId(movie.getId());
            movieResponse.setTitle(movie.getTitle());
            movieResponse.setDescription(movie.getDescription());
            movieResponse.setRating(movie.getRating());
            movieResponse.setImage(movie.getImage());
            movieResponse.setCreatedAt(movie.getCreatedAt().toString());
            movieResponse.setModifiedAt(movie.getModifiedAt().toString());

            return movieResponse;
        }).toList();

        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        null,
                        "Success Get All Movies",
                        movieResponseList
                )
        );
    }

    @Override
    public ResponseEntity<ApiResponse> getMovieDetail(Integer id) {

        Optional<Movie> movie = movieRep.findById(id);
        if (movie.isEmpty()) {
            return new ResponseEntity<>(
                    new ApiResponse(
                            false,
                            404,
                            "Failed Get Movie Detail",
                            null
                    ), HttpStatus.NOT_FOUND
            );
        }
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.get().getId());
        movieResponse.setTitle(movie.get().getTitle());
        movieResponse.setDescription(movie.get().getDescription());
        movieResponse.setRating(movie.get().getRating());
        movieResponse.setImage(movie.get().getImage());
        movieResponse.setCreatedAt(movie.get().getCreatedAt().toString());
        movieResponse.setModifiedAt(movie.get().getModifiedAt().toString());

        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        null,
                        "Success Get Movie Detail",
                        movieResponse
                )
        );
    }

    @Override
    public ResponseEntity<ApiResponse> addMovie(MovieCreateRequest request) {

        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setDescription(request.getDescription());
        movie.setRating(request.getRating());
        movie.setImage(request.getImage());
        movieRep.save(movie);

        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        null,
                        "Success Created Movie",
                        null
                )
        );
    }

    @Override
    public ResponseEntity<ApiResponse> updateMovie(
            Integer id,
            MovieUpdateRequest request
    ) {

        Optional<Movie> movieOpt = movieRep.findById(id);
        if (movieOpt.isEmpty()) {
            return new ResponseEntity<>(
                    new ApiResponse(
                            false,
                            404,
                            "Failed Updated Movie Detail Because Movie Id Not Found",
                            null
                    ), HttpStatus.NOT_FOUND
            );
        }
        Movie movie = movieOpt.get();
        movie.setTitle(request.getTitle());
        movieOpt.get().setDescription(request.getDescription());
        movieOpt.get().setRating(request.getRating());
        movieOpt.get().setImage(request.getImage());
        movieRep.save(movieOpt.get());

        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        null,
                        "Success Updated Movie",
                        null
                )
        );
    }

    @Override
    public ResponseEntity<ApiResponse> deleteMovie(Integer id) {

        Optional<Movie> movieOpt = movieRep.findById(id);
        if (movieOpt.isEmpty()) {
            return new ResponseEntity<>(
                    new ApiResponse(
                            false,
                            404,
                            "Failed Delete Movie Detail Because Movie Id Not Found",
                            null
                    ), HttpStatus.NOT_FOUND
            );
        }

        movieRep.deleteById(id);
        return ResponseEntity.ok(
                new ApiResponse(
                        true,
                        null,
                        "Success Deleted Movie",
                        null
                )
        );
    }
}
