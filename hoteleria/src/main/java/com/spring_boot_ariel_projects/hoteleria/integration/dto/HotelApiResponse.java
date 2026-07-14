package com.spring_boot_ariel_projects.hoteleria.integration.dto;

import java.util.List;

public record HotelApiResponse(
        boolean success,
        List<DetallesDelHotel> data,
        String message,
        Long timestamp
) {}
