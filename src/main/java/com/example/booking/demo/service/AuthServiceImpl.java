package com.example.booking.demo.service;

import com.example.booking.demo.dto.AuthDto;
import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.exceptions.UserNotFoundException;
import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.AuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    private AuthRepository authRepository;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.authRepository = authRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
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
                        .setRole(userDto.getRole())
                        .setUsername(userDto.getUsername())
                        .setPassword(userDto.getPassword());
            User savedUser = authRepository.save(user);
            log.info("saved user details {}", savedUser.toString());
            userDto.setId(savedUser.getId());
            return userDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String authenticate(AuthDto authDto) {
        try {
           Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword()));
            User user = authRepository.findByEmail(authDto.getEmail());
            log.info("user {}", user);
            String token = jwtService.generateToken(user);
            log.info("authentication : {}", authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("token {}", token);
            return token;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
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
