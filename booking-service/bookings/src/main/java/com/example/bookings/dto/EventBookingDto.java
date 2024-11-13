package com.example.bookings.dto;

import lombok.Data;

@Data
public class EventBookingDto {
    private Long eventId;
    private Long userId;
    private Long price;
}
