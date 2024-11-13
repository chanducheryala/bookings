package com.example.booking.demo.service;

import com.example.booking.demo.dto.AuthDto;
import com.example.booking.demo.dto.PersonDto;
import com.example.booking.demo.model.Person;
import org.springframework.stereotype.Service;


@Service
public interface AuthService {
    PersonDto register(PersonDto userDto);
    String authenticate(AuthDto authDto);
    Person findById(Long id);
}
