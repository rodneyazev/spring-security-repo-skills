package com.inmemory.app.controller;

import java.security.Principal;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController implements ErrorController {

	@GetMapping("/")
	public String index() {
		return "Hello, to Home page" ;
	}
	
	@GetMapping("/user")
	public String user(Principal principal) {
		return "Hello, " + principal.getName();
	}
	
	@GetMapping("/admin")
	public String admin(Principal principal) {
		return "Hello, " + principal.getName();
	}
	
	@GetMapping("/guru")
	public String guru(Principal principal) {
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