package com.example.booking.demo.controller;

import com.example.booking.demo.dto.LocationManagerDto;
import com.example.booking.demo.dto.LocationSubManagerDto;
import com.example.booking.demo.model.LocationManager;
import com.example.booking.demo.service.LocationSubManagerService;
import com.example.booking.demo.service.impl.LocationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/location-submanagers")
public class LocationSubManagerController {

    @Autowired
    private LocationSubManagerService locationSubManagerService;

    @PostMapping("")
    @PreAuthorize("hasAuthority('LOCATION_MANAGER')")
    public ResponseEntity<LocationSubManagerDto> create(@RequestBody LocationSubManagerDto locationSubManagerDto) {
        return new ResponseEntity<LocationSubManagerDto>(locationSubManagerService.create(locationSubManagerDto), HttpStatus.CREATED);
    }
}
