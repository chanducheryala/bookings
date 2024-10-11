package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.exceptions.NoEntryFound;
import com.example.booking.demo.exceptions.TicketSoldOutException;
import com.example.booking.demo.model.Event;
import com.example.booking.demo.model.LocationSubManager;
import com.example.booking.demo.model.SubLocation;
import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.EventRespository;
import com.example.booking.demo.repository.UserRepository;
import com.example.booking.demo.service.EventService;
import com.example.booking.demo.service.SubLocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRespository eventRespository;
    private SubLocationService subLocationService;
    private UserRepository userRepository;

    public EventServiceImpl(
            EventRespository eventRespository,
            SubLocationService subLocationService,
            UserRepository userRepository
    ) {
        this.eventRespository = eventRespository;
        this.subLocationService = subLocationService;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public EventDto create(EventDto eventDto, Long sub_location_id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LocationSubManager locationSubManager = (LocationSubManager) authentication.getPrincipal();
        Optional<SubLocation> subLocation = subLocationService.findById(sub_location_id);
        if(subLocation.isEmpty()) {
            throw new NoEntryFound(String.format("No Sublocation found %d ID", sub_location_id));
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
        Event savedEvent = eventRespository.save(event);
        eventDto.setId(savedEvent.getId());
        eventDto.setStatus(savedEvent.getStatus());
        return eventDto;
    }

    @Transactional
    @Override
    public synchronized void book(Long eventId) {
        Optional<Event> event = this.findById(eventId);
        if(event.isEmpty()) {
            throw new NoEntryFound(String.format("No Event found % id", eventId));
        }
        log.info("event is {}", event.get().toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        user.getEvents().add(event.get());
        event.get().getUsers().add(user);
        event.get().setBookedCapacity(event.get().getBookedCapacity() + 1);
        eventRespository.save(event.get());
        userRepository.save(user);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return eventRespository.findById(id);
    }
}
