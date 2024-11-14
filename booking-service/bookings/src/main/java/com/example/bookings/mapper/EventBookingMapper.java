package com.example.bookings.mapper;

import com.example.booking.demo.dto.EventBookingDto;
import com.example.bookings.model.EventBooking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", imports = LocalDateTime.class)
public interface EventBookingMapper {
    @Mapping(source = "eventId", target = "eventId")
    @Mapping(source = "userId", target = "userId")
    @Mapping(target = "bookingDate", expression = "java(LocalDateTime.now())")
    EventBooking toEntity(EventBookingDto eventBookingDto);

    @Mapping(source = "eventId", target = "eventId")
    @Mapping(source = "userId", target = "userId")
    EventBookingDto toDto(EventBooking entity);
}
