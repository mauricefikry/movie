package com.restfull.Movie.model.response;

import lombok.Data;

@Data
public class ApiResponse {
    
    private Boolean success;
    private Integer errorCode;
    private String message;
    private Object data;

    public ApiResponse(boolean success, Integer errorCode, String message, Object data) {
        this.success = success;
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }
}
