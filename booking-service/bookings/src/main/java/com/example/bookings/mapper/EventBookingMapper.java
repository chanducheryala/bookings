package com.example.bookings.mapper;

import com.example.bookings.dto.EventBookingDto;
import com.example.bookings.model.EventBooking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface EventBookingMapper {
    @Mapping(source = "event_id", target = "eventId")
    @Mapping(source = "user_id", target = "userId")
    @Mapping(target = "bookingDate", expression = "java(LocalDateTime.now())")
    EventBooking toEntity(EventBookingDto eventBookingDto);

    @Mapping(source = "eventId", target = "event_id")
    @Mapping(source = "userId", target = "user_id")
    EventBookingDto toDto(EventBooking entity);
}
