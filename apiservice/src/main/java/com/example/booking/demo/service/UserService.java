package com.example.booking.demo.service;

import com.example.booking.demo.dto.UserDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    UserDto create(UserDto userDto);
}
