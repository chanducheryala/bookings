package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.EventBookingDto;
import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.exceptions.NoEntryFound;
import com.example.booking.demo.model.Event;
import com.example.booking.demo.model.LocationSubManager;
import com.example.booking.demo.model.SubLocation;
import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.EventRepository;
import com.example.booking.demo.repository.UserRepository;
import com.example.booking.demo.service.EventService;
import com.example.booking.demo.service.SubLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final SubLocationService subLocationService;
    private final UserRepository userRepository;
    private final KafkaTemplate<String, EventBookingDto> kafkaTemplate;

    @Autowired
    public EventServiceImpl(
            EventRepository eventRepository,
            SubLocationService subLocationService,
            UserRepository userRepository,
            KafkaTemplate<String, EventBookingDto> kafkaTemplate
    ) {
        this.eventRepository = eventRepository;
        this.subLocationService = subLocationService;
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public EventDto create(EventDto eventDto, Long sub_location_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LocationSubManager locationSubManager = (LocationSubManager) authentication.getPrincipal();
        Optional<SubLocation> subLocation = subLocationService.findById(sub_location_id);
        if (subLocation.isEmpty()) {
            throw new NoEntryFound(String.format("No Sublocation found with ID %d", sub_location_id));
        }
        Event event = new Event()
                .setTitle(eventDto.getTitle())
                .setDescription(eventDto.getDescription())
                .setDate(eventDto.getDate())
                .setTime(eventDto.getTime())
                .setDuration(eventDto.getDuration())
                .setSubLocation(subLocation.get())
                .setCapacity(eventDto.getCapacity())
                .setLocationSubManager(locationSubManager);
        Event savedEvent = eventRepository.save(event);
        eventDto.setId(savedEvent.getId());
        eventDto.setStatus(savedEvent.getStatus());
        return eventDto;
    }

    @Override
    public synchronized void book(Long eventId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        log.info("User is: {}", user);
        Long userId = user.getId();
        EventBookingDto eventBookingDto = new EventBookingDto()
                .setEventId(eventId)
                .setUserId(userId)
                .setPrice(2000L);
        kafkaTemplate.send("event_bookings", eventBookingDto);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new NoEntryFound("No Event Found!"));
    }
}
