package com.database.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//Getting values from properties file
	@Value("${spring.ldap.urls}")
	private String ldapUrls;
	
	@Value("${spring.ldap.base}")
	private String ldapBaseDn;
	
	@Value("${spring.ldap.username}")
	private String ldapSecurityPrincipal;
	
	@Value("${spring.ldap.password}")
	private String ldapPrincipalPassword;
	
	@Value("${spring.ldap.user.dn.pattern}")
	private String ldapUserDnPattern;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		.csrf(csrf -> csrf
			.disable())	
		.authorizeHttpRequests(
			auth -> auth
			.requestMatchers("/v3/**", "/swagger-ui/**","/swagger/**").permitAll()
			.requestMatchers("/").authenticated())
		.formLogin(Customizer.withDefaults());
		//or .httpBasic(Customizer.withDefaults()) - Popup authentication box
		
		return http.build();
	}
	
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				.contextSource()
					.url(ldapUrls + ldapBaseDn)
						.managerDn(ldapSecurityPrincipal)
						.managerPassword(ldapPrincipalPassword)
					.and()
				.userDnPatterns(ldapUserDnPattern);
	}

}
