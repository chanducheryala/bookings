package com.example.booking.demo.dto;

public class SubLocationDto extends BaseLocationDto{
    private LocationSubManager locationSubManager;
    public SubLocationDto(String name, LocationSubManager locationSubManager) {
        super(name);
        this.locationSubManager = locationSubManager;
    }
}
