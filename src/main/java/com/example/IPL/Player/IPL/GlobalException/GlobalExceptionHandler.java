package com.example.IPL.Player.IPL.GlobalException;

import com.example.IPL.Player.IPL.Exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;
import static com.example.IPL.Player.IPL.GlobalException.ErrorResponse.*;
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Resource Not Found");
        errorResponse.put("message", ex.getMessage());
        errorResponse.put("status", String.valueOf(HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
