package com.example.booking.demo.service.impl;

import com.example.booking.demo.model.Person;
import com.example.booking.demo.repository.PersonRespository;
import com.example.booking.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRespository personRespository;
    @Override
    public List<Person> getUsers() {
        try {
            return personRespository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(Arrays.toString(e.getStackTrace()));
        }
    }

    @Override
    public Person findByEmail(String email) {
        if(email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        return personRespository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
