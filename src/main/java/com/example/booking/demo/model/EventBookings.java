package com.example.booking.demo.model;

import jakarta.persistence.*;

public class EventBookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "customer_id");
//    private User user;
}
