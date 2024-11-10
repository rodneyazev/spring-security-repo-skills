package com.spring.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();
		
		String hashedPassword = null;
		
		String pass = "USER";
		hashedPassword = passwordEnconder.encode(pass);
		System.out.println("USER password bcrypt hash encoder:\t" + hashedPassword);
		
		String word = "ADMIN";
		hashedPassword = passwordEnconder.encode(word);
		System.out.println("ADMIN password bcrypt hash encoder:\t" + hashedPassword);

	}

}
