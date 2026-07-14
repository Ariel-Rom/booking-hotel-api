package com.spring_boot_ariel_projects.hoteleria.integration.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DetallesDelHotel(
                                @JsonAlias("id_hotel")
                                Long id,
                                @JsonAlias("name")
                                String nombre,
                                @JsonAlias("city")
                                String ciudad,
                                @JsonAlias("country")
                                String pais,
                                @JsonAlias("address")
                                String direccion,
                                @JsonAlias("rating")
                                Long calificaciones,
                                @JsonAlias("amenities")
                                List<String> comodidades

                               ) {}
