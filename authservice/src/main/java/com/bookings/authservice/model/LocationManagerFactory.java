package com.bookings.authservice.model;

import com.bookings.authservice.dto.LocationManagerDto;
import com.bookings.authservice.dto.PersonDto;
import com.bookings.authservice.security.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LocationManagerFactory implements PersonFactory{
    @Override
    public Person create(PersonDto personDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl adminDetails = (UserDetailsImpl) authentication.getPrincipal();
        PersonDto adminDto = new PersonDto(
                adminDetails.getId(),
                adminDetails.getFirstName(),
                adminDetails.getLastName(),
                adminDetails.getEmail(),
                adminDetails.getPhoneNumber(),
                adminDetails.getPassword()
        );
        Admin admin = new Admin(adminDto);
        log.info("adminDto is {}", adminDto.toString());
        log.info("admin is {}", admin.toString());
        LocationManagerDto locationManagerDto = new LocationManagerDto(
                personDto.getFirstName(),
                personDto.getLastName(),
                personDto.getEmail(),
                personDto.getPhoneNumber(),
                personDto.getPhoneNumber(),
                admin
        );
        return new LocationManager(locationManagerDto);
    }

}
