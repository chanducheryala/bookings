package com.example.booking.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UsermanagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}
}