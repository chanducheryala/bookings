package com.bookings.user_management.controller;


import com.bookings.user_management.dto.LocationDto;
import com.bookings.user_management.service.LocationService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("")
    public ResponseEntity<LocationDto> create(@Valid @RequestBody LocationDto locationDto) {
        return new ResponseEntity<LocationDto>(locationService.create(locationDto), HttpStatus.CREATED);
    }
}
