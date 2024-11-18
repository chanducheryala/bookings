package com.bookings.user_management.dto;

import com.bookings.user_management.enums.Role;
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
