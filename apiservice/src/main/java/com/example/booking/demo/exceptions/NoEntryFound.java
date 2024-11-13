package com.example.booking.demo.exceptions;

import jakarta.validation.constraints.NotNull;

public class NoEntryFound extends RuntimeException{
    public NoEntryFound(@NotNull  final String message) {
        super(message);
    }
}
