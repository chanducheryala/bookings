package com.example.booking.demo.dto;

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
