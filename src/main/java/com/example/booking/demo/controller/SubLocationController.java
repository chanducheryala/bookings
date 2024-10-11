package com.example.booking.demo.controller;


import com.example.booking.demo.dto.SubLocationDto;
import com.example.booking.demo.model.SubLocation;
import com.example.booking.demo.service.SubLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sub-locations")
public class SubLocationController {

    @Autowired
    private SubLocationService subLocationService;

    @PostMapping("")
    public ResponseEntity<SubLocationDto> create(@RequestBody SubLocationDto subLocationDto) {
        return new ResponseEntity<SubLocationDto>(subLocationService.create(subLocationDto), HttpStatus.CREATED);
    }
}
