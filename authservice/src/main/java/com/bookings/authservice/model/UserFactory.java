package com.bookings.authservice.model;

import com.bookings.authservice.dto.PersonDto;
import org.springframework.stereotype.Component;


@Component
public class UserFactory implements PersonFactory{
    @Override
    public Person create(PersonDto personDto) {
        return new User(personDto);
    }
}
