package com.example.booking.demo.security;

import com.example.booking.demo.model.Person;
import com.example.booking.demo.model.User;
import com.example.booking.demo.repository.PersonRespository;
import lombok.experimental.Accessors;
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
    private PersonRespository personRespository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRespository.findByEmail(username);
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
