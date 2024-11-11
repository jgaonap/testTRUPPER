package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude=UserDetailsServiceAutoConfiguration.class)
public class PruebatruperApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatruperApplication.class, args);
	}

}
