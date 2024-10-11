package com.example.booking.demo.controller;


import com.example.booking.demo.dto.UserDto;
import com.example.booking.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        return new ResponseEntity<UserDto>(userService.create(userDto), HttpStatus.CREATED);
    }
}
