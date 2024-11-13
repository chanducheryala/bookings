package com.example.booking.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
public class Location extends BaseLocation{
    public Location(String name) {
        super(name);
    }

    @OneToOne
    @JoinColumn(name = "location_manager_id")
    private LocationManager locationManager;

    public Location(@NotBlank(message = "location name cannot be null") String name, LocationManager locationManager) {
        super(name);
        this.locationManager = locationManager;
    }
}
