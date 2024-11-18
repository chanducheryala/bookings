package com.bookings.user_management.service.impl;

import com.bookings.user_management.dto.LocationManagerDto;
import com.bookings.user_management.repository.LocationManagerRepository;
import com.bookings.user_management.service.LocationManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class LocationManagerServiceImpl implements LocationManagerService {
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    private LocationManagerRepository locationManagerRepository;

    @Override
    public LocationManagerDto create(LocationManagerDto locationManagerDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Admin admin = (Admin) authentication.getPrincipal();
//        locationManagerDto.setPassword(encoder.encode(locationManagerDto.getPassword()));
//        LocationManager locationManager = new LocationManager(
//                locationManagerDto.getFirstName(),
//                locationManagerDto.getLastName(),
//                locationManagerDto.getEmail(),
//                locationManagerDto.getPhoneNumber(),
//                locationManagerDto.getUsername(),
//                locationManagerDto.getPassword(),
//                admin
//        );
//        LocationManager savedLocationManager = locationManagerRepository.save(locationManager);
//        locationManager.setRole(savedLocationManager.getRole());
//        locationManager.setId(savedLocationManager.getId());
        return locationManagerDto;
    }
}
