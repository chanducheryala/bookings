package com.bookings.user_management.controller;

import com.bookings.user_management.dto.LocationManagerDto;
import com.bookings.user_management.service.LocationManagerService;
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
@RequestMapping("api/v1/location-managers")
public class LocationManagerController {

    @Autowired
    private LocationManagerService locationManagerService;

    public LocationManagerController(LocationManagerService locationManagerService) {
        this.locationManagerService = locationManagerService;
    }

    @PostMapping("")
    private ResponseEntity<LocationManagerDto> create(@RequestBody LocationManagerDto locationManagerDto) {
        log.info("locationManagerService {}", locationManagerService);
        return new ResponseEntity<LocationManagerDto>(locationManagerService.create(locationManagerDto), HttpStatus.CREATED);
    }

}
