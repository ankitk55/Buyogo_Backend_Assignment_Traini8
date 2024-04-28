package com.Ankit.Buyogo_Backend_Assignment_Traini8.exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String >handleDataIntegrityviolationException(DataIntegrityViolationException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getRootCause().getMessage());
    }

    @ExceptionHandler(DuplicateCenterNameException.class)
    public ResponseEntity<String >handleDuplicateCenterNameException(DuplicateCenterNameException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(DuplicateCenterPhoneNumberException.class)
    public ResponseEntity<String >handleDuplicateCenterPhoneNumberException(DuplicateCenterPhoneNumberException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
