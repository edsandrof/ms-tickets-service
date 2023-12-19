package com.github.edsandrof.ticketsservice.exception;

public class SeatNotAvailableException extends RuntimeException {

    public SeatNotAvailableException() {
        super();
    }

    public SeatNotAvailableException(String message) {
        super(message);
    }
}
