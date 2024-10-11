package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.exceptions.NoEntryFound;
import com.example.booking.demo.model.Event;
import com.example.booking.demo.model.LocationSubManager;
import com.example.booking.demo.model.SubLocation;
import com.example.booking.demo.repository.EventRespository;
import com.example.booking.demo.service.EventService;
import com.example.booking.demo.service.SubLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRespository eventRespository;
    private SubLocationService subLocationService;

    public EventServiceImpl(EventRespository eventRespository, SubLocationService subLocationService) {
        this.eventRespository = eventRespository;
        this.subLocationService = subLocationService;
    }


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
                .setLocationSubManager(locationSubManager);
        Event savedEvent = eventRespository.save(event);
        eventDto.setId(savedEvent.getId());
        return eventDto;
    }
}
