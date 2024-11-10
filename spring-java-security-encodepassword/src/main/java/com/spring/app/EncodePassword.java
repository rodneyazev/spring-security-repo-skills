package com.spring.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncodePassword {

	public static void main(String[] args) {
		
		BCryptPasswordEncoder passwordEnconder = new BCryptPasswordEncoder();
		
		String password1 = "USER";
		String hashedPassword1 = passwordEnconder.encode(password1);
		System.out.println("USER password bcrypt hash encoder:\t" + hashedPassword1);
		
		String password2 = "ADMIN";
		String hashedPassword2 = passwordEnconder.encode(password2);
		System.out.println("ADMIN password bcrypt hash encoder:\t" + hashedPassword2);

	}

}
