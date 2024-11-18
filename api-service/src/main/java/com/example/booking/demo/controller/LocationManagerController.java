package com.example.booking.demo.controller;

import com.example.booking.demo.dto.LocationManagerDto;
import com.example.booking.demo.service.LocationManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/location-managers")
public class LocationManagerController {

    @Autowired
    private LocationManagerService locationManagerService;

    public LocationManagerController(LocationManagerService locationManagerService) {
        this.locationManagerService = locationManagerService;
    }

    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    private ResponseEntity<LocationManagerDto> create(@RequestBody LocationManagerDto locationManagerDto) {
        log.info("locationManagerService {}", locationManagerService);
        return new ResponseEntity<LocationManagerDto>(locationManagerService.create(locationManagerDto), HttpStatus.CREATED);
    }

}
