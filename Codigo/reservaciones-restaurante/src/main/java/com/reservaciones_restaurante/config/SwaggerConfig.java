package com.reservaciones_restaurante.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("API de Reservaciones de Restaurante")
                            .version("1.0")
                            .description("Documentación de la API de Reservaciones de Restaurante"))
            .addSecurityItem(new SecurityRequirement().addList("basicScheme"))
            .components(new io.swagger.v3.oas.models.Components()
                            .addSecuritySchemes("basicScheme",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")));
    }
}


