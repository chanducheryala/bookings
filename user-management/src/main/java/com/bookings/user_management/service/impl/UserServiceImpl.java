package com.bookings.user_management.service.impl;

import com.bookings.user_management.dto.UserDto;
import com.bookings.user_management.model.User;
import com.bookings.user_management.repository.UserRepository;
import com.bookings.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getUsername(),
                userDto.getPassword()
        );
        User savedUser = userRepository.save(user);
        userDto.setId(savedUser.getId());
        return userDto;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
