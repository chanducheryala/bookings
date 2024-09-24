package com.example.booking.demo.dto;

import com.example.booking.demo.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {

    @NotBlank(message = "first name cannot be empty")
    private String firstName;

    @NotBlank(message = "last name cannot be empty")
    private String lastName;

    @NotBlank(message = "email cannot be empty")
    private String email;

    @NotBlank(message = "phone number cannot be empty")
    private String phoneNumber;

    public User toUser() {
        return new User(firstName, lastName, email, phoneNumber);
    }
}
