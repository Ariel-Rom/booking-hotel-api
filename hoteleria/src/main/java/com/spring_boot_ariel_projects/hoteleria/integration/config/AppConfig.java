package com.spring_boot_ariel_projects.hoteleria.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    private static final String API_KEY = "eec02f9761ec638b79700412290520134fdcf8678ac2ca442d9b3754a4d94e8f";

    @Bean
    RestClient restClient(){
        RestClient.Builder builder = RestClient.builder();
        return builder
                .baseUrl("https://api.hotels-api.com/v1")
                .defaultHeader("X-API-Key", API_KEY)
                .build();
    }

}
