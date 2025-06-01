package com.example.FarmersFriend.APIGateway;


import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerGatewayConfig {

    @Bean
    public List<GroupedOpenApi> apis() {
        return List.of(
                GroupedOpenApi.builder()
                        .group("user-service")
                        .pathsToMatch("/user/**")
                        .build(),
                GroupedOpenApi.builder()
                        .group("product-service")
                        .pathsToMatch("/product/**")
                        .build(),
                GroupedOpenApi.builder()
                        .group("cart-service")
                        .pathsToMatch("/cart/**")
                        .build()
        );
    }
}
