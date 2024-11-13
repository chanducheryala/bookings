package com.example.booking.demo.model;

import com.example.booking.demo.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
public class LocationSubManager extends Person {
    public LocationSubManager(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String email,
            @NotNull String phoneNumber,
            @NotNull String username,
            @NotNull String password
    ) {
        super(firstName, lastName, email, phoneNumber, username, password);
        this.setRole(Role.LOCATION_SUBMANAGER);
    }
    public LocationSubManager() {}

    @ManyToOne
    @JoinColumn(
            name = "location_manager_id"
    )
    private LocationManager locationManager;

    @OneToMany(mappedBy = "locationSubManager")
    private List<SubLocation> subLocations;

    @OneToMany(mappedBy = "locationSubManager")
    private List<Event> events;
}
