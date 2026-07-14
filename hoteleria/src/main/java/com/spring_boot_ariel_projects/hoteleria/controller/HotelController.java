package com.spring_boot_ariel_projects.hoteleria.controller;

import com.spring_boot_ariel_projects.hoteleria.integration.dto.HotelApiResponse;
import com.spring_boot_ariel_projects.hoteleria.integration.client.HotelApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {

    //URL Base: https://api.hotels-api.com/v1
    //Busqueda de hotel: /hotels/search

    private final HotelApiClient hotelAPIService;

    //https://api.hotels-api.com/v1/search?city=Buenos+Aires
    @GetMapping("/ciudad")
    public ResponseEntity<HotelApiResponse> busquedaHotelPorCiudad(@RequestParam String ciudad) {
        HotelApiResponse response = hotelAPIService.hotelesPorCiudad(ciudad);
        return ResponseEntity.ok(response);
    }

    //https://api.hotels-api.com/v1/search?name=Cabaña+don+julian
    @GetMapping("/nombre")
    public ResponseEntity<HotelApiResponse> busquedaHotelPorNombre(@RequestParam String nombre){
        HotelApiResponse response = hotelAPIService.hotelPorNombre(nombre);
        return ResponseEntity.ok(response);
    }

    //https://api.hotels-api.com/v1/search?country=Argentina
    @GetMapping("/pais")
    public ResponseEntity<HotelApiResponse> busquedaHotelPorPais(@RequestParam String pais){
        HotelApiResponse response = hotelAPIService.hotelesPorPais(pais);
        return ResponseEntity.ok(response);
    }



}
