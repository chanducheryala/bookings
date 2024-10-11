package com.example.booking.demo.controller;


import com.example.booking.demo.dto.LocationDto;
import com.example.booking.demo.model.Admin;
import com.example.booking.demo.service.LocationService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @PreAuthorize("hasAuthority('LOCATION_MANAGER')")
    public ResponseEntity<LocationDto> create(@Valid @RequestBody LocationDto locationDto) {
        return new ResponseEntity<LocationDto>(locationService.create(locationDto), HttpStatus.CREATED);
    }
}
