package com.bookings.authservice.security;

import com.bookings.authservice.model.Person;
import com.bookings.authservice.repository.PersonRepository;
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
    private PersonRepository personRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByEmail(username);
        if (person.isEmpty()) {
            throw new UsernameNotFoundException("No user found");
        }
        return new UserDetailsImpl(
                person.get().getId(),
                person.get().getFirstName(),
                person.get().getLastName(),
                person.get().getEmail(),
                person.get().getPhoneNumber(),
                person.get().getPassword(),
                List.of(new SimpleGrantedAuthority(person.get().getRole().getDisplayName()))
        );
    }
}
