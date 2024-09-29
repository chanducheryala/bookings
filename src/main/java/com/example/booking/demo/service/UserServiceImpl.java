package com.example.booking.demo.service;

import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRespository userRespository;
    @Override
    public List<User> getUsers() {
        try {
            return userRespository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public User findByEmail(String email) {
        if(email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        return userRespository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
