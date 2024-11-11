package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
public class PruebatruperApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebatruperApplication.class, args);
	}

}
