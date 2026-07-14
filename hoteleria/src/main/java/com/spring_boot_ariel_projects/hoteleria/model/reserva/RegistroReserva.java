package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record RegistroReserva(@NotBlank String nombreCliente,
                              @FutureOrPresent @NotNull LocalDateTime diaIngreso,
                              @FutureOrPresent @NotNull LocalDateTime diaEgreso,
                              @Min(1) @NotNull Long cantidadHuespedes,
                              @NotNull Long hotelId) {
    public RegistroReserva(Reserva reserva){
        this(   reserva.getNombreCliente(), reserva.getDiaIngreso(),
                reserva.getDiaEgreso(), reserva.getCantidadHuespedes(),
                reserva.getHotelId());
    }
}
