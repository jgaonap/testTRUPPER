package com.example.demo.component.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class FilterComponent {

	@Autowired
	private AutorizadorComponent authComp;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.csrf((csrf) -> csrf.disable()).authorizeHttpRequests(
				authz -> authz.requestMatchers(HttpMethod.POST, "/login").permitAll().anyRequest().authenticated())
				.addFilterAfter(authComp, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

}
