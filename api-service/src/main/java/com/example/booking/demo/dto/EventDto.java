package com.example.booking.demo.dto;

import com.example.booking.demo.enums.EventStatus;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class EventDto {
    private Long id;

    @NotBlank(message = "title cannot be null")
    private String title;

    @NotBlank(message = "description cannot be null")
    private String description;

    @NotBlank(message = "date cannot be null")
    private LocalDate date;

    @NotBlank(message = "time cannot be null")
    private LocalTime time;

    @NotBlank(message = "duration cannot be null")
    private int duration;

    @NotBlank(message = "capacity cannot be null")
    private Long capacity;

    private EventStatus status;
}
