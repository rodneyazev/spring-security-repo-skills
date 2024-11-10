package com.main.app.config;

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
	        .description("This API shows how to implement a Database authentication API.");
	    return new OpenAPI().info(info);
	}


}
