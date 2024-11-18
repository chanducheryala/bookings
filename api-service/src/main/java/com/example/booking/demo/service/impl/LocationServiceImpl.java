package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.BaseLocationDto;
import com.example.booking.demo.dto.LocationDto;
import com.example.booking.demo.model.Location;
import com.example.booking.demo.model.LocationManager;
import com.example.booking.demo.repository.LocationRepository;
import com.example.booking.demo.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDto create(LocationDto locationDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LocationManager locationManager = (LocationManager) authentication.getPrincipal();
        Location location = new Location(locationDto.getName(), locationManager);
        Location savedLocation = locationRepository.save(location);
        locationDto.setId(savedLocation.getId());
        return locationDto;
    }
}
