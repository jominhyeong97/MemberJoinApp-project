package com.example.demo.MemberJoin.ControllerExceptionHandler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public EntityResponse<?> NoSuch() {
        return null;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public EntityResponse<?> Illegal() {
        return null;
    }


}
