package com.hashicorp.quickstart.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vault API")
                        .version("1.0.0")
                        .description("API for interacting with HashiCorp Vault")
                        .contact(new Contact()
                                .name("Your Name")
                                .url("https://yourwebsite.com")
                                .email("youremail@example.com")));
    }
}
