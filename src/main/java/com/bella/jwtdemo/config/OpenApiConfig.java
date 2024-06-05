package com.bella.jwtdemo.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.List;

@OpenAPIDefinition
public class OpenApiConfig {
        @Value("${openapi.service.title}")
        private  String serviceTitle;

        @Value("${openapi.service.version}")
        private  String serviceVersion;

        @Value("${openapi.service.description}")
        private  String serviceDescription;

        @Value("${openapi.service.url}")
        private String url;

        @Bean
        public OpenAPI customOpenAPI() {
                final String securitySchemeName = "bearerAuth";
                return new OpenAPI()
                        .servers(List.of( new Server().url(url)))
                        .components(
                                new Components()
                                        .addSecuritySchemes(
                                                securitySchemeName,
                                                new SecurityScheme()
                                                        .type(SecurityScheme.Type.HTTP)
                                                        .scheme("bearer")
                                                        .bearerFormat("JWT")))
                        .security(List.of(new SecurityRequirement().addList(securitySchemeName)))
                        .info(new Info().title(serviceTitle).version(serviceVersion).description(serviceDescription));
        }
}