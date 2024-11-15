package com.example.booking.demo.controller;

import com.example.booking.demo.dto.AuthDto;
import com.example.booking.demo.dto.PersonDto;
import com.example.booking.demo.model.Person;
import com.example.booking.demo.service.AuthService;
import com.example.booking.demo.security.JwtService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@Slf4j
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String getHello() {
        return "Hello";
    }

    @PostMapping("/register")
    public ResponseEntity<PersonDto> create(@Valid  @RequestBody PersonDto userDto) {
        try {
            log.info("userDto is {}", userDto);
            userDto.setPassword(encoder.encode(userDto.getPassword()));
            return new ResponseEntity<PersonDto>(authService.register(userDto), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error during registration: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
        try{
            log.info("id is {}", id);
            return new ResponseEntity<Person>(authService.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @PostMapping("/login")
    public String login(@RequestBody AuthDto authDto) {
        try {
            log.info("authDto : {}", authDto.toString());
            return authService.authenticate(authDto);
        } catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
