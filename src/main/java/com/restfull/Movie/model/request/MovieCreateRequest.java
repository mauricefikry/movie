package com.restfull.Movie.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieCreateRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Double rating;

    @NotNull
    private String image;
}
