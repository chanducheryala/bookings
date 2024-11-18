package com.bookings.user_management.dto;

import com.bookings.user_management.model.LocationManager;
import lombok.Data;

@Data
public class LocationDto extends BaseLocationDto {
    private LocationManager locationManager;
    public LocationDto(String name, LocationManager locationManager) {
        super(name);
        this.locationManager = locationManager;
    }
}