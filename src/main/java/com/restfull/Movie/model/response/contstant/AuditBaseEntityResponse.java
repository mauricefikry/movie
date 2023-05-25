package com.restfull.Movie.model.response.contstant;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuditBaseEntityResponse {

    @JsonProperty("created_At")
    private String createdAt;

    @JsonProperty("modified_At")
    private String modifiedAt;
}
