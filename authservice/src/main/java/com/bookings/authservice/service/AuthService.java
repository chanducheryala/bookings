package com.bookings.authservice.service;

import com.bookings.authservice.dto.AuthDto;
import com.bookings.authservice.dto.UserDto;

public interface AuthService {
    UserDto create(UserDto userDto);
    String authenticate(AuthDto authDto);
}
