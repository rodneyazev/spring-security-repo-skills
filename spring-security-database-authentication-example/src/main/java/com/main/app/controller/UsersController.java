package com.main.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.app.entity.Users;
import com.main.app.repository.UsersRepository;

@RestController
@RequestMapping("/")
public class UsersController {
	
	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> authenticateUser(@RequestBody Users users){
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(
					users.getUsername(), users.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User login successfully!.", HttpStatus.OK);
	}

    @GetMapping
    public Principal retrievePrincipal(Principal principal) {
        return principal;
    }
    
    @GetMapping("/error")
	public String error() {
		return "Access denied. Not enough permission.";
	}

	public String getErrorPath() {
		return error();
	}
}
