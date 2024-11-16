package com.bookings.authservice.service;

import com.bookings.authservice.dto.AuthDto;
import com.bookings.authservice.dto.UserDto;
import com.bookings.authservice.model.User;
import com.bookings.authservice.repository.UserRepository;
import com.bookings.authservice.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public AuthServiceImpl(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    @Override
    public UserDto create(UserDto userDto) {
        User user = new User(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPhoneNumber(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRole()
        );
        User savedUser = userRepository.save(user);
        userDto.setId(savedUser.getId());
        return userDto;
    }

    @Override
    public String authenticate(AuthDto authDto) {
        try {
            Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword()));
            Optional<User> user = userRepository.findByEmail(authDto.getEmail());
            if(user.isPresent()) {
                String token = jwtService.generateToken(user.get());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return token;
            } else {
                return "No User found !";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
