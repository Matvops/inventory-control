package com.cadenassi.inventory_control.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException() {
    }

    public InvalidArgumentException(String message) {
        super(message);
    }
}
