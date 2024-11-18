package com.bookings.user_management.service.impl;

import com.bookings.user_management.dto.AdminDto;
import com.bookings.user_management.model.Admin;
import com.bookings.user_management.repository.AdminRepository;
import com.bookings.user_management.service.AdminService;

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
