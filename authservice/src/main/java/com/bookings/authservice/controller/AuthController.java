package com.bookings.authservice.controller;

import com.bookings.authservice.dto.AuthDto;
import com.bookings.authservice.dto.PersonDto;
import com.bookings.authservice.service.AuthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @PostMapping("/register")
    public ResponseEntity<PersonDto> create(@Valid @RequestBody PersonDto personDto) {
        try {
            log.info("personDto is {}", personDto.toString());
            personDto.setPassword(encoder.encode(personDto.getPassword()));
            return new ResponseEntity<PersonDto>(authService.create(personDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthDto authDto) {
        try {
            return authService.authenticate(authDto);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
