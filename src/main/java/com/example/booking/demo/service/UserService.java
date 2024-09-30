package com.example.booking.demo.service;

import com.example.booking.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User findByEmail(String email);
}
