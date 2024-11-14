package com.example.booking.demo.service;

import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.model.Event;

public interface EventService {
    EventDto create(EventDto eventDto, Long sub_location_id);

    void book(Long id);
    Event findById(Long id);
}
