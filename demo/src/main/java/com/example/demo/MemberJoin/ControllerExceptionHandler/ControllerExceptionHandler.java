package com.example.demo.MemberJoin.ControllerExceptionHandler;


import com.example.demo.MemberJoin.author.Dto.CommonErrorDto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> NoSuch(NoSuchElementException e) {

        return new ResponseEntity<>(
                new CommonErrorDto(e.getMessage(), HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> Illegal(IllegalArgumentException e) {
        return new ResponseEntity<>(
                new CommonErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> NotFoundEntity (EntityNotFoundException e) {
        return new ResponseEntity<>(
                new CommonErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<?> entityExists (EntityExistsException e) {
        return new ResponseEntity<>(
                new CommonErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()),HttpStatus.BAD_REQUEST);
    }


}
