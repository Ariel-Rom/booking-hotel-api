package com.spring_boot_ariel_projects.hoteleria.service;

import com.spring_boot_ariel_projects.hoteleria.model.cliente.ActualizarCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.DetallesDeCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.RegistroDeDatosCliente;

import java.util.List;

public interface IClienteService {

    DetallesDeCliente registrar(RegistroDeDatosCliente registroDeDatosCliente);
    DetallesDeCliente obtener(Long idCliente);
    List<DetallesDeCliente> obtenerListaCliente();
    DetallesDeCliente actualizar(ActualizarCliente actualizarCliente, Long idCliente);
    void eliminar(Long idCliente);

}
