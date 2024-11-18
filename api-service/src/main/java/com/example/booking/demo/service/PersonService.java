package com.example.booking.demo.service;

import com.example.booking.demo.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getUsers();
    Person findByEmail(String email);
}
