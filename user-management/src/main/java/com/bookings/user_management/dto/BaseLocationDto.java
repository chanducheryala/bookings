package com.bookings.user_management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public abstract class BaseLocationDto {
    private Long id;
    @NotBlank(message = "location name cannot be null")
    private String name;

    public BaseLocationDto() {}

    public BaseLocationDto(String name) {
        this.name = name;
    }
}
