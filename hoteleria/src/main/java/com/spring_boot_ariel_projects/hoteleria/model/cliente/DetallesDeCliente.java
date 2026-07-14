package com.spring_boot_ariel_projects.hoteleria.model.cliente;

public record DetallesDeCliente(Long id,
                                String nombre,
                                String apellido,
                                String dni) {
    public DetallesDeCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getDni());
    }
}
