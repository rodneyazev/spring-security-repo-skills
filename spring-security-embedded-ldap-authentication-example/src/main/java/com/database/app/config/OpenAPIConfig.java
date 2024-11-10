package com.database.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    OpenAPI myOpenAPI() {
		Info info = new Info()
	        .title("API Documentation")
	        .version("1.0")
	        .description("This API shows how to implement an Embedded LDAP Server authentication API. Username: ben - Password: benspassword - LDAP file: users.ldif");
	    return new OpenAPI().info(info);
	}

}
