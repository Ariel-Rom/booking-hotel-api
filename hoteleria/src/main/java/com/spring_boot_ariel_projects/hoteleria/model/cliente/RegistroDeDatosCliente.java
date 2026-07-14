package com.spring_boot_ariel_projects.hoteleria.model.cliente;

import jakarta.validation.constraints.NotBlank;

public record RegistroDeDatosCliente(@NotBlank String nombre,@NotBlank String apellido,
                                     @NotBlank String dni) {
}
