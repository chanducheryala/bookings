package com.example.booking.demo.service;

import com.example.booking.demo.dto.EventDto;

public interface EventService {
    EventDto create(EventDto eventDto, Long sub_location_id);
}
