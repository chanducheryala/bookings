package com.example.booking.demo.dto;

import com.example.booking.demo.model.Admin;
import com.example.booking.demo.model.LocationManager;
import lombok.Data;

@Data
public class LocationDto extends BaseLocationDto{
    private LocationManager locationManager;
    public LocationDto(String name, LocationManager locationManager) {
        super(name);
        this.locationManager = locationManager;
    }
}