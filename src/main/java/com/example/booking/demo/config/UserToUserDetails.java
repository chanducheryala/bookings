package com.example.booking.demo.config;

import com.example.booking.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UserToUserDetails implements UserDetails {

    private String username;
    private String password;
    private List<GrantedAuthority> roles;

    public UserToUserDetails(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.roles = (List<GrantedAuthority>) user.getAuthorities();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
