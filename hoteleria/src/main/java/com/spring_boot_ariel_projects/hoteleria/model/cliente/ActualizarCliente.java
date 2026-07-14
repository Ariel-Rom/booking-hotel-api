package com.spring_boot_ariel_projects.hoteleria.model.cliente;

import jakarta.validation.constraints.NotBlank;

public record ActualizarCliente(@NotBlank String nombre,
                                @NotBlank String apellido,
                                @NotBlank String dni) {

    public ActualizarCliente(Cliente cliente){
        this(cliente.getNombre(), cliente.getApellido(), cliente.getDni());
    }

}
