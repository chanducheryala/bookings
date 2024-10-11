package com.example.booking.demo.service;

import com.example.booking.demo.dto.SubLocationDto;
import com.example.booking.demo.exceptions.NoEntryFound;
import com.example.booking.demo.model.SubLocation;

import java.util.Optional;

public interface SubLocationService {
    SubLocationDto create(SubLocationDto subLocationDto);
    Optional<SubLocation> findById(Long id);

}
