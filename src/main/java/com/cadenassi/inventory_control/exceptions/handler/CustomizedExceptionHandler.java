package com.cadenassi.inventory_control.exceptions.handler;

import com.cadenassi.inventory_control.exceptions.ExceptionResponse;
import com.cadenassi.inventory_control.exceptions.InvalidArgumentException;
import com.cadenassi.inventory_control.exceptions.ObjectIsNullException;
import com.cadenassi.inventory_control.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<ExceptionResponse> invalidArgumentHandler(RuntimeException exception, WebRequest request){
        var response = new ExceptionResponse(exception.getMessage(), Instant.now(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(ObjectIsNullException.class)
    public ResponseEntity<ExceptionResponse> objectIsNullHandler(RuntimeException exception, WebRequest request){
        var response = new ExceptionResponse(exception.getMessage(), Instant.now(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(RuntimeException exception, WebRequest request){
        var response = new ExceptionResponse(exception.getMessage(), Instant.now(),
                request.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
