package com.example.booking.demo.service;

import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.AuthRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class AuthServiceImpl implements AuthService{

    private AuthRepository authRepository;

    @Autowired
    public AuthServiceImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public User register(User user) {
        try {
            if(user.getFirstName().trim().length() == 0) {
                throw new IllegalArgumentException("first name shouldn't be empty");
            } else if(user.getLastName().trim().length() == 0) {
                throw new IllegalArgumentException("last name shouldn't be empty");
            } else if(user.getPhoneNumber().trim().length() == 0) {
                throw new IllegalArgumentException("phone number shouldn't be empty");
            } else if(user.getEmail().trim().length() == 0) {
                throw new IllegalArgumentException("email shouldn't be empty");
            }
            return authRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }
    }
}
