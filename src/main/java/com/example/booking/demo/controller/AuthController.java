package com.example.booking.demo.controller;

import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.enums.Role;
import com.example.booking.demo.model.User;
import com.example.booking.demo.service.AuthService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Validated
@Slf4j
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> create(@Valid  @RequestBody UserDto userDto, @RequestParam(required = false, name = "role") Role role) {
        try {
            log.info("role is {}", role);
            userDto.setRole(role);
            log.info("userDto is {}", userDto);
            return new ResponseEntity<UserDto>(authService.register(userDto), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error during registration: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") UUID id) {
        try{
            log.info("id is {}", id);
            return new ResponseEntity<User>(authService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
