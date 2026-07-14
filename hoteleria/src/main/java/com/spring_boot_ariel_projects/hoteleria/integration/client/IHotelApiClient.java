package com.spring_boot_ariel_projects.hoteleria.integration.client;

import com.spring_boot_ariel_projects.hoteleria.integration.dto.HotelApiResponse;

public interface IHotelApiClient {

    HotelApiResponse hotelesPorCiudad(String ciudad);
    HotelApiResponse hotelesPorPais(String pais);
    HotelApiResponse hotelPorNombre(String nombre);


}
