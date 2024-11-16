package com.bookings.authservice.controller;

import com.bookings.authservice.dto.AuthDto;
import com.bookings.authservice.dto.UserDto;
import com.bookings.authservice.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto) {
        try {
            userDto.setPassword(encoder.encode(userDto.getPassword()));
            return new ResponseEntity<UserDto>(authService.create(userDto), HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthDto authDto) {
        try {
//            log.info("authDto : {}", authDto.toString());
            return authService.authenticate(authDto);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
