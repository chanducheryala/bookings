package com.bookings.authservice.service;

import com.bookings.authservice.dto.AuthDto;
import com.bookings.authservice.dto.PersonDto;
import com.bookings.authservice.model.Person;
import com.bookings.authservice.model.PersonFactoryProvider;
import com.bookings.authservice.repository.PersonRepository;
import com.bookings.authservice.security.JwtService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private PersonRepository personRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private PersonFactoryProvider personFactoryProvider;

    public AuthServiceImpl(
            PersonRepository personRepository,
            AuthenticationManager authenticationManager,
            JwtService jwtService,
            PersonFactoryProvider personFactoryProvider
    ) {
        this.personRepository = personRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.personFactoryProvider = personFactoryProvider;
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        Person person = personFactoryProvider.getFactory(personDto.getRole().getDisplayName()).create(personDto);
        log.info("person {}", person);
        Person savedPerson = personRepository.save(person);
        log.info("saved person {}", savedPerson);
        personDto.setId(savedPerson.getId());
        return personDto;
    }

    @Override
    public String authenticate(AuthDto authDto) {
        try {
            Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getPassword()));
            Optional<Person> user = personRepository.findByEmail(authDto.getEmail());
            if(user.isPresent()) {
                String token = jwtService.generateToken(user.get());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                return token;
            } else {
                return "No User found !";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
