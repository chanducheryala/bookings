package com.example.booking.demo.service;

import com.example.booking.demo.model.User;
import com.example.booking.demo.model.UserPrincipal;
import com.example.booking.demo.repository.MyUserDetailsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserDetailsRepository myUserDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         if(username.trim().isEmpty()) {
             throw new IllegalArgumentException("username cannot be empty");
         }
         log.info("username {}", username);
        User user = myUserDetailsRepository.findByUsername(username);
        log.info("user {}", user);
         if(user == null) {
             throw new UsernameNotFoundException("No user found");
         }
         return new UserPrincipal(user);
    }
}
