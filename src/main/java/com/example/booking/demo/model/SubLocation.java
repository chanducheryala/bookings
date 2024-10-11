package com.example.booking.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
public class SubLocation extends BaseLocation{

    public SubLocation(@NotNull final String name) {
        super(name);
    }

    @ManyToOne
    @JoinColumn(name =  "location_sub_manager_id")
    private LocationSubManager locationSubManager;

    public SubLocation(@NotBlank(message = "location name cannot be null") String name, LocationSubManager locationSubManager) {
        super(name);
        this.locationSubManager = locationSubManager;
    }
}
