package com.example.bookings.consumer;


import com.example.bookings.dto.EventBookingDto;
import com.example.bookings.service.EventBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;


public class EventBookingConsumer {

    @Autowired
    private EventBookingService eventBookingService;

    @KafkaListener(topics = "event_bookings", groupId = "event_booking_group_1")
    public void listen(EventBookingDto eventBookingDto) {
        eventBookingService.book(eventBookingDto);
    }
}
