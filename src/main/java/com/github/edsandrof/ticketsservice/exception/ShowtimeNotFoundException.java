package com.github.edsandrof.ticketsservice.exception;

public class ShowtimeNotFoundException extends RuntimeException {

    public ShowtimeNotFoundException() {
        super();
    }

    public ShowtimeNotFoundException(String message) {
        super(message);
    }
}
