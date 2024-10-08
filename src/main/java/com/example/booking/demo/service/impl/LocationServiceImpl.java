package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.LocationDto;
import com.example.booking.demo.model.Location;
import com.example.booking.demo.repository.LocationRepository;
import com.example.booking.demo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDto create(LocationDto locationDto) {
        Location location = new Location().setName(locationDto.getName());
        Location savedLocation = locationRepository.save(location);
        locationDto.setId(savedLocation.getId());
        return locationDto;
    }
}
