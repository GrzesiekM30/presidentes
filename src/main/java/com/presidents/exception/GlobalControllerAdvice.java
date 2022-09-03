package com.presidents.exception;

import com.presidents.exception.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<Object> handleEntityNotFoundException(Exception e){
        Map<Object, Object> body = getBody(HttpStatus.NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public final ResponseEntity<Object> handleHttpMessageNotReadableExceptions(Exception e){
        Map<Object, Object> body = getBody(HttpStatus.BAD_REQUEST, e.getMessage().substring(0,(e.getMessage().indexOf(":"))+1));
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private static Map<Object, Object> getBody(HttpStatus status, String message) {
        Map<Object, Object> body = new LinkedHashMap<>();
        body.put("timestamp", Instant.now());
        body.put("code", status.value());
        body.put("message", message);
        return body;
    }

}
