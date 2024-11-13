package com.example.booking.demo.controller;


import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('LOCATION_SUBMANAGER')")
    public ResponseEntity<EventDto> create(@RequestBody EventDto eventDto, @RequestParam("sub-location") final Long sub_location_id) {
        return new ResponseEntity<EventDto>(eventService.create(eventDto, sub_location_id), HttpStatus.CREATED);
    }

}
