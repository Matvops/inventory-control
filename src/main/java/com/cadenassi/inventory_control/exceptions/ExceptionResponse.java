package com.cadenassi.inventory_control.exceptions;


import java.io.Serializable;
import java.time.Instant;

public class ExceptionResponse implements Serializable {

    private String message;
    private Instant timestamp;
    private String details;

    public ExceptionResponse(String message, Instant timestamp, String details) {
        this.message = message;
        this.timestamp = timestamp;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }


    public String getDetails() {
        return details;
    }
}
