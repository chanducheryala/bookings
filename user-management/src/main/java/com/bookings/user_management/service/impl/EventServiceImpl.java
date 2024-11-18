package com.bookings.user_management.service.impl;

import com.bookings.user_management.dto.EventBookingDto;
import com.bookings.user_management.dto.EventDto;
import com.bookings.user_management.exceptions.NoEntryFound;
import com.bookings.user_management.model.Event;
import com.bookings.user_management.repository.EventRepository;
import com.bookings.user_management.repository.UserRepository;
import com.bookings.user_management.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final KafkaTemplate<String, EventBookingDto> kafkaTemplate;

    @Autowired
    public EventServiceImpl(
            EventRepository eventRepository,
            UserRepository userRepository,
            KafkaTemplate<String, EventBookingDto> kafkaTemplate
    ) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public EventDto create(EventDto eventDto, Long sub_location_id) {
//        Event event = new EventBookingDto()
//                .setTitle(eventDto.getTitle())
//                .setDescription(eventDto.getDescription())
//                .setDate(eventDto.getDate())
//                .setTime(eventDto.getTime())
//                .setDuration(eventDto.getDuration())
//                .setSubLocation(subLocation.get())
//                .setCapacity(eventDto.getCapacity())
//                .setLocationSubManager(locationSubManager);
//        Event savedEvent = eventRepository.save(event);
//        eventDto.setId(savedEvent.getId());
//        eventDto.setStatus(savedEvent.getStatus());
        return eventDto;
    }

    @Override
    public synchronized void book(Long eventId) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        log.info("User is: {}", user);
//        Long userId = user.getId();
//        EventBookingDto eventBookingDto = new EventBookingDto()
//                .setEventId(eventId)
//                .setUserId(userId)
//                .setPrice(2000L);
//        kafkaTemplate.send("event_bookings", eventBookingDto);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new NoEntryFound("No Event Found!"));
    }
}
