package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.component.security.AutenticadorComponent;
import com.example.demo.model.entity.User;

public class SecurityController {

	@Autowired
	private AutenticadorComponent autComponent;

	@PostMapping("login")
	public User login(@RequestParam("user") String username, @RequestParam("pwd") String encryptedPass) {

		/**
		 * En el ejemplo no se realiza la correcta validación del usuario
		 */

		String token = autComponent.getJWTToken(username);
		return new User(username, encryptedPass, token);

	}

}
