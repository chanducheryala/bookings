package com.example.booking.demo.controller;

import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.enums.Role;
import com.example.booking.demo.model.User;
import com.example.booking.demo.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

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
    public ResponseEntity<User> create(@RequestBody UserDto userDto, @RequestParam(required = false, name = "role") Role role) {
        try {
            log.info("query param is {}", role);
            User user = userDto.toUser();
            user.setRole(role);
            log.info("user is {}", user.getFirstName());
            log.info("userDto is {}", userDto);
            return new ResponseEntity<User>(authService.register(user), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error during registration: {}", e.getMessage());
            throw new IllegalArgumentException(e);
        }
    }
}
