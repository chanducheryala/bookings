package com.example.booking.demo.dto;
import com.example.booking.demo.model.LocationSubManager;

public class SubLocationDto extends BaseLocationDto{
    private LocationSubManager locationSubManager;
    public SubLocationDto(String name, LocationSubManager locationSubManager) {
        super(name);
        this.locationSubManager = locationSubManager;
    }
}
