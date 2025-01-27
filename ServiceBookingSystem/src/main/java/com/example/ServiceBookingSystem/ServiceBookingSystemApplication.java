package com.example.ServiceBookingSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.ServiceBookingSystem.repository")
public class ServiceBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceBookingSystemApplication.class, args);
	}

}
