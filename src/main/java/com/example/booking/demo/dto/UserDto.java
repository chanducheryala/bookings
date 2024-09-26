package com.example.booking.demo.dto;

import com.example.booking.demo.enums.Role;
import com.example.booking.demo.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;

    @NotBlank(message = "first name cannot be empty")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    private String lastName;

    @NotBlank(message = "email cannot be empty")
    private String email;

    @NotBlank(message = "phone number cannot be empty")
    private String phoneNumber;

    private Role role;

    public User toUser() {
        return new User(firstName, lastName, email, phoneNumber);
    }
}
