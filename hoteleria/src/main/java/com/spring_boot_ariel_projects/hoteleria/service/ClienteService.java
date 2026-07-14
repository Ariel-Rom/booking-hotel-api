package com.spring_boot_ariel_projects.hoteleria.service;


import com.spring_boot_ariel_projects.hoteleria.model.cliente.ActualizarCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.DetallesDeCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.RegistroDeDatosCliente;

import java.util.List;

public class ClienteService implements IClienteService{

    @Override
    public DetallesDeCliente registrar(RegistroDeDatosCliente registroDeDatosCliente) {
        return null;
    }

    @Override
    public DetallesDeCliente obtener(Long idCliente) {
        return null;
    }

    @Override
    public List<DetallesDeCliente> obtenerListaCliente() {
        return List.of();
    }

    @Override
    public DetallesDeCliente actualizar(ActualizarCliente actualizarCliente, Long idCliente) {
        return null;
    }

    @Override
    public void eliminar(Long idCliente) {

    }
}
