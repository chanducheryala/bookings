package com.example.booking.demo.dto;

import com.example.booking.demo.model.Admin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LocationDto {
    private Long id;

    @NotBlank(message = "location name cannot be null")
    private String name;

    private Admin admin;

}
