package com.example.booking.demo.controller;

import com.example.booking.demo.dto.LocationManagerDto;
import com.example.booking.demo.service.LocationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/location-manager")
public class LocationManagerController {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    private LocationManagerService locationManagerService;

    @PostMapping("/register")
    private ResponseEntity<LocationManagerDto> create(@RequestBody LocationManagerDto locationManagerDto) {
        locationManagerDto.setPassword(encoder.encode(locationManagerDto.getPassword()));
        return new ResponseEntity<LocationManagerDto>(locationManagerService.create(locationManagerDto), HttpStatus.CREATED);
    }
}
