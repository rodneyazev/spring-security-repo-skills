package com.project.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {

	@GetMapping
	public ResponseEntity<Void> security(){
		return ResponseEntity.ok().build();
	}
	
}
