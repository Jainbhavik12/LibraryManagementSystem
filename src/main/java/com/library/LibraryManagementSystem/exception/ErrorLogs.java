package com.library.LibraryManagementSystem.exception;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ErrorLogs {
    private LocalDateTime timestamp;
    private String status;
    private String message;


    public ErrorLogs(String status, String message) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
    }


}
