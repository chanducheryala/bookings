package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.UserRepository;
import com.example.booking.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
}