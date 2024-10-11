package com.example.booking.demo.service;

import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.model.Event;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface EventService {
    EventDto create(EventDto eventDto, Long sub_location_id);

    @Transactional
    void book(Long id);
    Optional<Event> findById(Long id);
}
