package com.spring_boot_ariel_projects.hoteleria.integration.client;

import com.spring_boot_ariel_projects.hoteleria.integration.dto.HotelApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class HotelApiClient implements IHotelApiClient {

    private final RestClient restClient;

    @Override
    public HotelApiResponse hotelesPorCiudad(String ciudad) {
     return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/hotels/search")
                                .queryParam("city", ciudad)
                                .build())
                .retrieve()
                .body(HotelApiResponse.class);
    }

    @Override
    public HotelApiResponse hotelesPorPais(String pais) {
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/hotels/search")
                                .queryParam("country", pais)
                                .build())
                .retrieve()
                .body(HotelApiResponse.class);
    }

    @Override
    public HotelApiResponse hotelPorNombre(String nombre) {
        return restClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/hotels/search")
                                .queryParam("name", nombre)
                                .build())
                .retrieve()
                .body(HotelApiResponse.class);
    }



}
