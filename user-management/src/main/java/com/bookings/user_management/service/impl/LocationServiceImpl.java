package com.bookings.user_management.service.impl;

import com.bookings.user_management.dto.LocationDto;
import com.bookings.user_management.repository.LocationRepository;
import com.bookings.user_management.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDto create(LocationDto locationDto) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        LocationManager locationManager = (LocationManager) authentication.getPrincipal();
//        Location location = new Location(locationDto.getName(), locationManager);
//        Location savedLocation = locationRepository.save(location);
//        locationDto.setId(savedLocation.getId());
        return locationDto;
    }
}
