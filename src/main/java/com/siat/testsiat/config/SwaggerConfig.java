package com.siat.testsiat.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo(){
        return new Info()
                    .title("Siat PJT")
                    .description("todo")
                    .version("0.0.1");
    }

}
