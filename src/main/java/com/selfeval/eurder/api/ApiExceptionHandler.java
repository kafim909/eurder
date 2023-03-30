package com.selfeval.eurder.api;

import com.selfeval.eurder.domain.exceptions.UnauthorizedException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    protected void entryNotFoundException(NoSuchElementException exception, HttpServletResponse response) throws IOException {
        response.sendError(NOT_FOUND.value(), exception.getMessage());
    }
    @ExceptionHandler(IllegalAccessException.class)
    protected void unauthorizedException(UnauthorizedException exception, HttpServletResponse response) throws  IOException {
        response.sendError(FORBIDDEN.value(), exception.getMessage());
    }

}
