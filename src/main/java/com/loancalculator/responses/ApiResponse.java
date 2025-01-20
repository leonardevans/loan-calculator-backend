package com.loancalculator.responses;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse {
    private LocalDateTime timestamp = LocalDateTime.now();
    private boolean success;
    private String message;
    private Map<String , ?> data = new HashMap<>();
    Map<String, String> errors = new HashMap<>();

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
