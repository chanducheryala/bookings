package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.AuthDto;
import com.example.booking.demo.dto.PersonDto;
import com.example.booking.demo.exceptions.UserNotFoundException;
import com.example.booking.demo.model.Person;
import com.example.booking.demo.repository.AuthRepository;
import com.example.booking.demo.service.AuthService;
import com.example.booking.demo.security.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

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
    public PersonDto register(PersonDto userDto) {
        try {
            return userDto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String authenticate(AuthDto authDto) {
        try {
           Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword()));
            Person person = authRepository.findByEmail(authDto.getEmail());
            log.info("user {}", person.toString());
            String token = jwtService.generateToken(person);
            log.info("authentication : {}", authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("token {}", token);
            return token;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Person findById(Long id) {
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
