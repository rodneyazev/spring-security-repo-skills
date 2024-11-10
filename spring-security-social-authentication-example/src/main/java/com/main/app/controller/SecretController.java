package com.main.app.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {
	
	@GetMapping("/")
	public String index(@AuthenticationPrincipal OAuth2User user) {
		return "Hello, " + user.getAttribute("name");
	}
	
	@GetMapping("/error")
	public String error() {
		return "Access denied. Not enough permission.";
	}

	public String getErrorPath() {
		return error();
	}

}
