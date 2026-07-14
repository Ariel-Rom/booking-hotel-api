package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ActualizarReserva(@NotNull Long hotelId,
                                @NotBlank String nombreCliente,
                                @FutureOrPresent @NotNull LocalDate diaIngreso,
                                @FutureOrPresent @NotNull LocalDate diaEgreso,
                                @Min(1) @NotNull Long cantidadHuespedes) {
}
