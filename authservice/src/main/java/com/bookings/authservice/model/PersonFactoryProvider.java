package com.bookings.authservice.model;


import com.bookings.authservice.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PersonFactoryProvider {

    @Autowired
    private final UserFactory userFactory;
    private final AdminFactory adminFactory;
    private final LocationManagerFactory locationManagerFactory;

    public PersonFactoryProvider(
            @NotNull UserFactory userFactory,
            @NotNull AdminFactory adminFactory,
            @NotNull LocationManagerFactory locationManagerFactory
    ) {
        this.userFactory = userFactory;
        this.adminFactory = adminFactory;
        this.locationManagerFactory = locationManagerFactory;
    }

    public PersonFactory getFactory(String role) {
        log.info("role is : {}", role);
        if(role.equals(Role.USER.getDisplayName())) {
            return userFactory;
        } else if(role.equals(Role.ADMIN.getDisplayName())) {
            return adminFactory;
        } else if(role.equals(Role.LOCATION_MANAGER.getDisplayName())){
            return locationManagerFactory;
        }
        return userFactory;
    }
}
