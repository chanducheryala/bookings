package com.example.booking.demo.model;

import com.example.booking.demo.enums.Role;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.util.List;


@Entity
@Table(name = "admin")
public class Admin extends Person{
    public Admin(
            @NotNull String firstName,
            @NotNull String lastName,
            @NotNull String email,
            @NotNull String phoneNumber,
            @NotNull String username,
            @NotNull String password
    ) {
        super(firstName, lastName, email, phoneNumber, username, password);
        this.setRole(Role.ADMIN);
    }
    public Admin() {}

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    private List<LocationManager> locationManagers;
}
