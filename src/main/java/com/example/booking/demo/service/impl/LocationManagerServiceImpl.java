package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.LocationManagerDto;
import com.example.booking.demo.model.LocationManager;
import com.example.booking.demo.repository.LocationManagerRepository;
import com.example.booking.demo.service.LocationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationManagerServiceImpl implements LocationManagerService {

    @Autowired
    private LocationManagerRepository locationManagerRepository;

    @Override
    public LocationManagerDto create(LocationManagerDto locationManagerDto) {
        LocationManager locationManager = new LocationManager(
                locationManagerDto.getFirstName(),
                locationManagerDto.getLastName(),
                locationManagerDto.getEmail(),
                locationManagerDto.getPhoneNumber(),
                locationManagerDto.getUsername(),
                locationManagerDto.getPassword()
        );
        LocationManager savedLocationManager = locationManagerRepository.save(locationManager);
        locationManager.setRole(savedLocationManager.getRole());
        locationManager.setId(savedLocationManager.getId());
        return locationManagerDto;
    }
}
