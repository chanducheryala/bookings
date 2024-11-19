package com.bookings.authservice.model;

import com.bookings.authservice.dto.PersonDto;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public interface PersonFactory {
    Person create(PersonDto personDto);
}
