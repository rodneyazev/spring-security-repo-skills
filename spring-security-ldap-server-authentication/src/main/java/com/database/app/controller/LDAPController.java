package com.database.app.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LDAPController {
	
	@GetMapping("/")
	public String user(Principal principal) {
		return "Hello, " + principal.getName();
	}
	
	@GetMapping("/error")
	public String error() {
		return "Access denied. Not enough permission.";
	}

	public String getErrorPath() {
		return error();
	}

}
