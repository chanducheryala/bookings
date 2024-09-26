package com.example.booking.demo.service;

import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.model.User;

import java.util.UUID;

public interface AuthService {
    UserDto register(UserDto userDto);

    User findById(UUID id);
}
