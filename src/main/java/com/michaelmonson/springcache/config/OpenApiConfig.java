package com.michaelmonson.springcache.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI usersMicroserviceOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("SpringBootCaching")
						.description("A sample application to test the latest features of SpringBoot, a RESTful API, and caching")
						.version("1.0"));
	}
}