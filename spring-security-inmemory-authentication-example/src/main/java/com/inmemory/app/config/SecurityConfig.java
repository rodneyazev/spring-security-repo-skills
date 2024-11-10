package com.inmemory.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	@Bean
	BCryptPasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
			.csrf(csrf -> csrf
				.disable())	
			.authorizeHttpRequests(
				auth -> auth
					.requestMatchers("/", "/v3/**", "/swagger-ui/**","/swagger/**").permitAll()
					.requestMatchers("/user").hasAnyRole("USER","ADMIN","GURU")
					.requestMatchers("/admin").hasAnyRole("ADMIN","GURU")
					.requestMatchers("/guru").hasRole("GURU")
					.anyRequest().authenticated())
			.formLogin(Customizer.withDefaults());	//or .httpBasic(Customizer.withDefaults()) - Popup authentication box
			
		return http.build();		
	}
	
	@Bean
	UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    
	    manager.createUser(User.withUsername("user")
	    	.password(bCryptPasswordEncoder.encode("password"))
	      	.roles("USER")
	      	.build());
	    
	    manager.createUser(User.withUsername("admin")
	    	.password(bCryptPasswordEncoder.encode("password"))
	      	.roles("ADMIN")
	      	.build());
	    
	    manager.createUser(User.withUsername("guru")
	    	.password(bCryptPasswordEncoder.encode("password"))
	  	    .roles("GURU")
	  	    .build());
	    
	    return manager;
	}
	
}