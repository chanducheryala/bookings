package com.example.booking.demo.service.impl;

import com.example.booking.demo.dto.AdminDto;
import com.example.booking.demo.model.Admin;
import com.example.booking.demo.repository.AdminRepository;
import com.example.booking.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public AdminDto create(AdminDto adminDto) {
        Admin admin = new Admin(adminDto.getFirstName(), adminDto.getLastName(), adminDto.getEmail(), adminDto.getPhoneNumber(), adminDto.getUsername(), adminDto.getPassword());
        Admin savedAdmin = adminRepository.save(admin);
        adminDto.setId(adminDto.getId());
        return adminDto;
    }
}
