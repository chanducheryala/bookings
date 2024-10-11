package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.SubLocationDto;
import com.example.booking.demo.model.LocationSubManager;
import com.example.booking.demo.model.SubLocation;
import com.example.booking.demo.repository.SubLocationRepository;
import com.example.booking.demo.service.SubLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SubLocationServiceImpl implements SubLocationService {

    @Autowired
    private SubLocationRepository subLocationRepository;

    @Override
    public SubLocationDto create(SubLocationDto subLocationDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LocationSubManager locationSubManager = (LocationSubManager) authentication.getPrincipal();
        SubLocation subLocation = new SubLocation(subLocationDto.getName(), locationSubManager);
        SubLocation savedSubLocation = subLocationRepository.save(subLocation);
        subLocationDto.setId(savedSubLocation.getId());
        return subLocationDto;
    }
}
