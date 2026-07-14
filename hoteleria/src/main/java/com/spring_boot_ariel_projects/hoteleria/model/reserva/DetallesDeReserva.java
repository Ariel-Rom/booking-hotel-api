package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record DetallesDeReserva(
                                LocalDate diaIngreso,
                                LocalDate diaEgreso,
                                Long cantidadHuespedes,
                                Long userId,
                                Long hotelId
) {
    public DetallesDeReserva(Reserva reserva){
        this(   reserva.getDiaIngreso(),
                reserva.getDiaEgreso(),
                reserva.getCantidadHuespedes(),
                reserva.getUserId(),
                reserva.getHotelId());
    }
}
