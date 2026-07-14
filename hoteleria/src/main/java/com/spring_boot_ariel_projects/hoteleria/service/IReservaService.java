package com.spring_boot_ariel_projects.hoteleria.service;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.ActualizarReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.DetallesDeReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.RegistroReserva;

import java.util.List;

public interface IReservaService {

    DetallesDeReserva obtener(Long idReserva);
    List<DetallesDeReserva> obtenerListaReserva();
    DetallesDeReserva registrar(RegistroReserva registroReserva);
    DetallesDeReserva actualizar(ActualizarReserva actualizarReserva);
    void eliminar(Long idReserva);


}
