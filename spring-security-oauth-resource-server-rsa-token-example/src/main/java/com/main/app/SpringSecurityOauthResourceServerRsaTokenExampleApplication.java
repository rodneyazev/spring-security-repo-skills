package com.main.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.main.app.config.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class SpringSecurityOauthResourceServerRsaTokenExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauthResourceServerRsaTokenExampleApplication.class, args);
	}

}
