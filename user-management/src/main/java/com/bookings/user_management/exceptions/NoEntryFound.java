package com.bookings.user_management.exceptions;

import jakarta.validation.constraints.NotNull;

public class NoEntryFound extends RuntimeException{
    public NoEntryFound(@NotNull  final String message) {
        super(message);
    }
}
