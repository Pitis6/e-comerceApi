package com.felipe.ecomrecev1;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EComreceApiv1Application {

	public static void main(String[] args) {
		SpringApplication.run(EComreceApiv1Application.class, args);
	}
	@Bean
	public OpenAPI customOpenAPI(){
		return new OpenAPI()
				.info(new Info()
						.title("audiophile API")
						.version("1.0")
						.description("API for audiophile "));
	}
}
