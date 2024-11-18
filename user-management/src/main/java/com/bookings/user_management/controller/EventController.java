package com.bookings.user_management.controller;


import com.bookings.user_management.dto.EventDto;
import com.bookings.user_management.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<EventDto> create(@RequestBody EventDto eventDto, @RequestParam("sub-location") final Long sub_location_id) {
        return new ResponseEntity<EventDto>(eventService.create(eventDto, sub_location_id), HttpStatus.CREATED);
    }

    @PutMapping("/book")
//    @PreAuthorize("hasAuthority('USER')")
    public void book(@RequestParam("eventId") Long eventId) {
        eventService.book(eventId);
    }

}
