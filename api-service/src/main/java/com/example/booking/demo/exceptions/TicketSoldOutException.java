package com.example.booking.demo.exceptions;

import jakarta.validation.constraints.NotNull;

public class TicketSoldOutException extends RuntimeException{
    public TicketSoldOutException(@NotNull final String message) {
        super(message);
    }
}
