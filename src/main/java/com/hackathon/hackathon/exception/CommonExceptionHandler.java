package com.hackathon.hackathon.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleRuntimeException(RuntimeException e) {
        log.error("Generic exception occurred", e);
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity handleUserNotFoundException(UserNotFoundException e) {
        log.error("User not found:", e);
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
