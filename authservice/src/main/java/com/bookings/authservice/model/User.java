package com.bookings.authservice.model;


import com.bookings.authservice.dto.PersonDto;
import com.bookings.authservice.enums.Role;
import jakarta.persistence.Entity;

@Entity
public class User extends Person{

    public User(PersonDto personDto) {
        super(
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getEmail(),
                personDto.getPhoneNumber(),
                personDto.getPassword(),
                Role.USER
        );
    }
}
