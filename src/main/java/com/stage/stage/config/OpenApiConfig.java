package com.stage.stage.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("STAGE API")
                        .version("1.0")
                        .description("API para monitoreo de planta de tratamiento de agua para diálisis.")
                        .contact(new Contact()
                                .name("Equipo STAGE")
                                .email("equipo@stage.com")
                                .url("https://stage.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                )
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor Local"),
                        new Server().url("https://stage.com/api").description("Servidor Producción")
                ));
    }
}
