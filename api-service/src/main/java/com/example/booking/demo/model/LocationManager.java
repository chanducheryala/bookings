package com.example.booking.demo.model;

import com.example.booking.demo.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class LocationManager extends Person{
    public LocationManager(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String email,
            @NotNull String phoneNumber,
            @NotNull String username,
            @NotNull String password,
            Admin admin
    ) {
        super(firstName, lastName, email, phoneNumber, username, password);
        this.setRole(Role.LOCATION_MANAGER);
        this.admin = admin;
    }
    public LocationManager() {}

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @OneToOne(mappedBy = "locationManager")
    private Location location;

}
