package com.bookings.authservice.service;

import com.bookings.authservice.dto.AuthDto;
import com.bookings.authservice.dto.PersonDto;

public interface AuthService {
    PersonDto create(PersonDto userDto);
    String authenticate(AuthDto authDto);
}
