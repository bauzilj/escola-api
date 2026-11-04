package com.superdev.escolaapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    OpenAPI escolaApiInfo() {
        return new OpenAPI()
                .info(new Info().title("Escola API")
                        .version("v1")
                        .description("API REST en JAVA Spring Boot de prática para SuperDev8."));
    }
}
