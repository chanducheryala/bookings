package com.bookings.user_management.service;

import com.bookings.user_management.dto.EventDto;
import com.bookings.user_management.model.Event;

public interface EventService {
    EventDto create(EventDto eventDto, Long sub_location_id);

    void book(Long id);
    Event findById(Long id);
}
