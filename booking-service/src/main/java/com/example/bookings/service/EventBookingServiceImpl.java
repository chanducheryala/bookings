package com.example.bookings.service;

import com.example.booking.demo.dto.EventBookingDto;
import com.example.bookings.repository.EventBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventBookingServiceImpl implements EventBookingService {

    @Autowired
    private EventBookingRepository eventBookingRepository;


    @Override
    public void book(EventBookingDto eventBookingDto) {
    }
}
