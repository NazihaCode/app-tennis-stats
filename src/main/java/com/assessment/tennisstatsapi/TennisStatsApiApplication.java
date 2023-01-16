package com.assessment.tennisstatsapi;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TennisStatsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TennisStatsApiApplication.class, args);
	}


	@Bean
	public OpenAPI tennisStatsOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Tennis Stats API")
						.description("The Tennis Stats API allows you to see stats about tennis players.")
						.version("v0.0.1"))
                		.externalDocs(new ExternalDocumentation()
						.description("Tennis Stats API Github repository")
						.url("http://localhost:8080/swagger-ui.html"));
	}

}
