package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.LocationSubManagerDto;
import com.example.booking.demo.model.LocationManager;
import com.example.booking.demo.model.LocationSubManager;
import com.example.booking.demo.repository.LocationSubManagerRepository;
import com.example.booking.demo.service.LocationSubManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationSubManagerServiceImpl implements LocationSubManagerService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
    @Autowired
    private LocationSubManagerRepository locationSubManagerRepository;

    @Override
    public LocationSubManagerDto create(LocationSubManagerDto locationSubManagerDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LocationManager locationManager = (LocationManager) authentication.getPrincipal();
        locationSubManagerDto.setLocationManager(locationManager);
        locationSubManagerDto.setPassword(encoder.encode(locationSubManagerDto.getPassword()));
        LocationSubManager locationSubManager = new LocationSubManager(
                locationSubManagerDto.getFirstName(),
                locationSubManagerDto.getLastName(),
                locationSubManagerDto.getEmail(),
                locationSubManagerDto.getPhoneNumber(),
                locationSubManagerDto.getUsername(),
                locationSubManagerDto.getPassword()
        );
        log.info("locationSubManagerDto {}", locationSubManagerDto);
        LocationSubManager savedLocationSubManager = locationSubManagerRepository.save(locationSubManager);
        locationSubManagerDto.setLocationManager(null);
        locationSubManagerDto.setId(savedLocationSubManager.getId());
        return locationSubManagerDto;
    }
}