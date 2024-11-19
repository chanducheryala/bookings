package com.bookings.authservice.dto;


import com.bookings.authservice.model.Admin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocationManagerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Admin admin;

    public LocationManagerDto(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String email,
            @NotNull String phoneNumber,
            @NotNull String password,
            @NotNull Admin admin
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.admin = admin;
    }
}
