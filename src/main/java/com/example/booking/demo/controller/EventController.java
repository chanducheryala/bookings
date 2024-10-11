package com.example.booking.demo.controller;


import com.example.booking.demo.dto.EventDto;
import com.example.booking.demo.model.Event;
import com.example.booking.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("")
    @PreAuthorize("hasAuthority('LOCATION_SUBMANAGER')")
    public ResponseEntity<EventDto> create(@RequestBody EventDto eventDto, @RequestParam("sub-location") final Long sub_location_id) {
        return new ResponseEntity<EventDto>(eventService.create(eventDto, sub_location_id), HttpStatus.CREATED);
    }

    @PutMapping("/book")
    @PreAuthorize("hasAuthority('USER')")
    public void book(@RequestParam("eventId") Long eventId) {
        eventService.book(eventId);
    }
}
