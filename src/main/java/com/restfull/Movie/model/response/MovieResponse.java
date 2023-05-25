package com.restfull.Movie.model.response;

import com.restfull.Movie.model.response.contstant.AuditBaseEntityResponse;
import lombok.Data;

@Data
public class MovieResponse extends AuditBaseEntityResponse {

    private Integer id;
    private String title;
    private String description;
    private Double rating;
    private String image;

}
