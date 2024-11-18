package com.bookings.user_management.controller;


import com.bookings.user_management.dto.AdminDto;
import com.bookings.user_management.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<AdminDto> create(@Valid @RequestBody AdminDto adminDto) {
        adminDto.setPassword(encoder.encode(adminDto.getPassword()));
        return new ResponseEntity<AdminDto>(adminService.create(adminDto), HttpStatus.CREATED);
    }
}
