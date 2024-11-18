package com.bookings.user_management.service;

import com.bookings.user_management.dto.UserDto;
import com.bookings.user_management.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    UserDto create(UserDto userDto);
    List<User> getUsers();
}
