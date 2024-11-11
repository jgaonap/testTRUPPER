package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.component.security.AutenticadorComponent;
import com.example.demo.model.entity.User;

@RestController
public class SecurityController {

	@Autowired
	private AutenticadorComponent autComponent;

	@PostMapping("login")
	public User login(@RequestBody User usuario) {
		String token = autComponent.getJWTToken(usuario);
		usuario.setToken(token);
		return usuario;
	}

}
