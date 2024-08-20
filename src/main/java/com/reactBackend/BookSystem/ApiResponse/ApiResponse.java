package com.reactBackend.BookSystem.ApiResponse;

import lombok.Data;

@Data
public class ApiResponse {

    private boolean success;
    private String message;


    public ApiResponse(String message, boolean success) {
        this.success = success;
        this.message = message;
    }
}
