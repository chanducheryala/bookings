package com.bookings.authservice.model;

import com.bookings.authservice.dto.PersonDto;
import com.bookings.authservice.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Admin extends Person{

    public Admin(){}
    public Admin(PersonDto personDto) {
        super(
                personDto.getId(),
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getEmail(),
                personDto.getPhoneNumber(),
                personDto.getPassword(),
                Role.ADMIN
        );
    }

    @OneToMany(cascade = CascadeType.REMOVE)
    Set<LocationManager> locationManagers;
}
