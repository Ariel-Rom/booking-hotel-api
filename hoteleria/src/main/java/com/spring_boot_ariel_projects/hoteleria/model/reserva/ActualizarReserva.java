package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ActualizarReserva(@NotNull Long hotelId,
                                @NotBlank String nombreCliente,
                                @FutureOrPresent @NotNull LocalDateTime diaIngreso,
                                @FutureOrPresent @NotNull LocalDateTime diaEgreso,
                                @Min(1) @NotNull Long cantidadHuespedes) {
}
