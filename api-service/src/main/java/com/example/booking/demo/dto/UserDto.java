package com.example.booking.demo.dto;

import com.example.booking.demo.enums.Role;
import jakarta.validation.constraints.NotNull;


public class UserDto extends PersonDto {
    public UserDto(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String email,
            @NotNull String phoneNumber,
            @NotNull String username,
            @NotNull String password
    ) {
        super(firstName, lastName, email, phoneNumber, username, password);
        this.setRole(Role.USER);
    }
}
