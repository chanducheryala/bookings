package com.example.booking.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class BranchDto {

    private UUID id;

    @NotBlank(message = "title cannot be null")
    private String title;

    @NotBlank(message = "location cannot be null")
    private String location;

}
