package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegistroReserva(
                              @FutureOrPresent @NotNull LocalDate diaIngreso,
                              @FutureOrPresent @NotNull LocalDate diaEgreso,
                              @Min(1) @NotNull Long cantidadHuespedes,
                              @NotNull Long hotelId,
                              @NotNull Long userId) {
    public RegistroReserva(Reserva reserva){
        this(   reserva.getDiaIngreso(),
                reserva.getDiaEgreso(), reserva.getCantidadHuespedes(),
                reserva.getHotelId(), reserva.getUserId());
    }
}
