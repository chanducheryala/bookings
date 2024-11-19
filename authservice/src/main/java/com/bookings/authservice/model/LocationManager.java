package com.bookings.authservice.model;

import com.bookings.authservice.dto.LocationManagerDto;
import com.bookings.authservice.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LocationManager extends Person {

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public LocationManager(LocationManagerDto locationManagerDto) {
        super(
                locationManagerDto.getFirstName(),
                locationManagerDto.getLastName(),
                locationManagerDto.getEmail(),
                locationManagerDto.getPhoneNumber(),
                locationManagerDto.getPassword(),
                Role.LOCATION_MANAGER
        );
        this.admin = locationManagerDto.getAdmin();
    }
}
