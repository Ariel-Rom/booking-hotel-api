package com.spring_boot_ariel_projects.hoteleria.integration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AppConfig {

    @Value("${api.hotels.key}")
    private String apiKey;

    @Bean
    RestClient restClient(){
        RestClient.Builder builder = RestClient.builder();
        return builder
                .baseUrl("https://api.hotels-api.com/v1")
                .defaultHeader("X-API-Key", apiKey)
                .build();
    }

}
