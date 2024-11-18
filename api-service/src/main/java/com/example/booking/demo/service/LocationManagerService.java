package com.example.booking.demo.service;

import com.example.booking.demo.dto.LocationManagerDto;
import org.springframework.stereotype.Service;

@Service
public interface LocationManagerService {
    LocationManagerDto create(LocationManagerDto locationManagerDto);
}
