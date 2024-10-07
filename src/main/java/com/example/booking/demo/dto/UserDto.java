package com.example.booking.demo.dto;

import com.example.booking.demo.enums.Role;
import com.example.booking.demo.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class UserDto {
    private Long id;

    @NotBlank(message = "first name cannot be empty")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    private String lastName;

    @NotBlank(message = "email cannot be empty")
    private String email;

    @NotBlank(message = "phone number cannot be empty")
    private String phoneNumber;

    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "password cannot be empty")
    private String password;

    private Role role;


    public UserDto(@NotNull String firstName, @NotNull String lastName, @NotNull String email, @NotNull String phoneNumber, @NotNull String username, @NotNull String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
    }
}
