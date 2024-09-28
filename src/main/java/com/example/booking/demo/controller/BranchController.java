package com.example.booking.demo.controller;

import com.example.booking.demo.dto.BranchDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/branches")
public class BranchController {

    @PostMapping("")
    public BranchDto create (@Valid @RequestBody BranchDto branchDto) {
        try {
            return new BranchDto();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
