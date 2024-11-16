package com.bookings.authservice.security;

import com.bookings.authservice.model.User;
import com.bookings.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> person = userRepository.findByEmail(username);
        if (person.isEmpty()) {
            throw new UsernameNotFoundException("No user found");
        }
        return new UserDetailsImpl(
                person.get().getId(),
                person.get().getEmail(),
                person.get().getPassword(),
                List.of(new SimpleGrantedAuthority(person.get().getRole().getDisplayName()))
        );
    }
}
