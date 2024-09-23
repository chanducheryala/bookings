package com.example.booking.demo.controller;

import com.example.booking.demo.enums.Role;
import com.example.booking.demo.model.User;
import com.example.booking.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class AuthController {
    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("v1/auth")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("v1/auth/register")
    public User create(User user, @RequestParam(required = false) Role role) {
        try {
            user.setRole(role);
            return authService.register(user);
        } catch (Exception e) {
            throw new IllegalArgumentException(Arrays.toString(e.getStackTrace()));
        }
    }
}
