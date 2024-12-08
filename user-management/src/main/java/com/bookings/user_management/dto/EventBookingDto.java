package com.bookings.user_management.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class EventBookingDto {
    private Long eventId;
    private Long userId;
    private Long price;
}