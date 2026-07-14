package com.spring_boot_ariel_projects.hoteleria.service;

import com.spring_boot_ariel_projects.hoteleria.model.cliente.ActualizarCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.DetallesDeCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.RegistroDeDatosCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClienteService {

    DetallesDeCliente registrar(RegistroDeDatosCliente registroDeDatosCliente);
    DetallesDeCliente obtener(Long idCliente);
    Page<DetallesDeCliente> obtenerListaCliente(Pageable pageable);
    DetallesDeCliente actualizar(ActualizarCliente actualizarCliente, Long idCliente);
    void eliminar(Long idCliente);

}
