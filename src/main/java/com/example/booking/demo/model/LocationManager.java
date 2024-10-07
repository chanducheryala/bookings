package com.example.booking.demo.model;

import com.example.booking.demo.enums.Role;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
public class LocationManager extends User{
    public LocationManager(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String email,
            @NotNull String phoneNumber,
            @NotNull String username,
            @NotNull String password
    ) {
        super(firstName, lastName, email, phoneNumber, username, password);
        this.setRole(Role.LOCATION_MANAGER);
    }
    public LocationManager() {}
}
