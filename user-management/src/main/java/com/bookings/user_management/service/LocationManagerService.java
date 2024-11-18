package com.bookings.user_management.service;

import com.bookings.user_management.dto.LocationManagerDto;
import org.springframework.stereotype.Service;

@Service
public interface LocationManagerService {
    LocationManagerDto create(LocationManagerDto locationManagerDto);
}
