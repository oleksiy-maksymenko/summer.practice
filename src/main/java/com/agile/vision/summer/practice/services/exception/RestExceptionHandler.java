package com.agile.vision.summer.practice.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NonExistingIdException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public void handleNonExistingID() {}

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleNullPointer() {}

}
