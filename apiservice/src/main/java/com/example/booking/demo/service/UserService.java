package com.example.booking.demo.service;

import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    UserDto create(UserDto userDto);
    List<User> getUsers();
}
