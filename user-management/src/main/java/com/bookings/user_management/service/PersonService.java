package com.bookings.user_management.service;

import com.bookings.user_management.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> getUsers();
    Person findByEmail(String email);
}
