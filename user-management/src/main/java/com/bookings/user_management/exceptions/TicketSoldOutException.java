package com.bookings.user_management.exceptions;

import jakarta.validation.constraints.NotNull;

public class TicketSoldOutException extends RuntimeException{
    public TicketSoldOutException(@NotNull final String message) {
        super(message);
    }
}
