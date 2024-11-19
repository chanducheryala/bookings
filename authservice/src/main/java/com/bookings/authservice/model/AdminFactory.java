package com.bookings.authservice.model;

import com.bookings.authservice.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class AdminFactory implements PersonFactory{
    @Override
    public Person create(PersonDto personDto) {
        return new Admin(personDto);
    }
}
