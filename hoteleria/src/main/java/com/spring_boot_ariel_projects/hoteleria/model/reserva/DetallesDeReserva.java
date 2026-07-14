package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import java.time.LocalDateTime;


public record DetallesDeReserva(
                                String nombreCliente,
                                LocalDateTime diaIngreso,
                                LocalDateTime diaEgreso,
                                Long cantidadHuespedes,
                                Long userId,
                                Long hotelId
) {
    public DetallesDeReserva(Reserva reserva){
        this(reserva.getNombreCliente(), reserva.getDiaIngreso(),
                reserva.getDiaEgreso(),
                reserva.getCantidadHuespedes(),
                reserva.getUserId(), reserva.getHotelId());
    }
}
