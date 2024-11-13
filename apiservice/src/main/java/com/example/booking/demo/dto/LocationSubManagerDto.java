package com.example.booking.demo.dto;

import com.example.booking.demo.enums.Role;
import com.example.booking.demo.model.LocationManager;
import jakarta.validation.constraints.NotNull;




public class LocationSubManagerDto extends PersonDto {
    public LocationSubManagerDto(
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
    private LocationManager locationManager;
    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }
}
