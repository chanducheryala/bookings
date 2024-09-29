package com.example.booking.demo.service;

import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.exceptions.UserNotFoundException;
import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    private AuthRepository authRepository;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public UserDto register(UserDto userDto) {
        try {
            User user = new User()
                        .setFirstName(userDto.getFirstName())
                        .setLastName(userDto.getLastName())
                        .setEmail(userDto.getEmail())
                        .setRole(userDto.getRole())
                        .setPhoneNumber(userDto.getPhoneNumber())
                        .setRole(userDto.getRole());
            User savedUser = authRepository.save(user);
            log.info("saved user details {}", savedUser.toString());
            userDto.setId(savedUser.getId());
            return userDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        try {
            if(id == null) {
                throw new IllegalArgumentException("Id cannot be NULL");
            }
            return authRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
