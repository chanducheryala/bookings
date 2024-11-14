package com.example.bookings.consumer;

import com.example.booking.demo.dto.EventBookingDto;
import com.example.bookings.service.EventBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class EventBookingConsumer {

    @Autowired
    private EventBookingService eventBookingService;

    @KafkaListener(topics = "event_bookings", groupId = "event_booking_group_1")
    public void listen(EventBookingDto eventBookingDto) {
        log.info("received event is : {}", eventBookingDto.toString());
        eventBookingService.book(eventBookingDto);
    }
}
