package com.example.booking.demo.config;

import com.example.booking.demo.model.Person;
import com.example.booking.demo.service.JwtService;
import com.example.booking.demo.service.PersonService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Slf4j
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final PersonService personService;

    @Autowired
    public JwtAuthFilter(JwtService jwtService, PersonService personService) {
        this.jwtService = jwtService;
        this.personService = personService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                String username = jwtService.extractUsername(token);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    authenticateUser(request, token, username);
                }
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        filterChain.doFilter(request, response);
    }

    private void authenticateUser(HttpServletRequest request, String token, String username) {
        Person person = personService.findByEmail(username);
        if(person != null && jwtService.validateToken(token, person)) {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    person, null, person.getAuthorities()
            );
            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authToken);
        } else {
            log.info("Token validation failed for user {}", username);
        }
    }
}
