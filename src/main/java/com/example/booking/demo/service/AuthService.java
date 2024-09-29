package com.example.booking.demo.service;

import com.example.booking.demo.dto.AuthDto;
import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface AuthService {
    UserDto register(UserDto userDto);
    String authenticate(AuthDto authDto);
    User findById(Long id);
}
