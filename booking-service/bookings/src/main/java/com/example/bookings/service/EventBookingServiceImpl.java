package com.example.bookings.service;

import com.example.bookings.dto.EventBookingDto;
import com.example.bookings.mapper.EventBookingMapper;
import com.example.bookings.model.EventBooking;
import com.example.bookings.repository.EventBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    private EventBookingRepository eventBookingRepository;
    private EventBookingMapper eventBookingMapper;

    public EventBookingServiceImpl(EventBookingRepository eventBookingRepository, EventBookingMapper eventBookingMapper) {
        this.eventBookingRepository = eventBookingRepository;
        this.eventBookingMapper = eventBookingMapper;
    }

    @Override
    public void book(EventBookingDto eventBookingDto) {
        EventBooking eventBooking = eventBookingMapper.toEntity(eventBookingDto);
        EventBooking savedEventBooking = eventBookingRepository.save(eventBooking);
    }
}
