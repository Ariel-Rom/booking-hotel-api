package com.spring_boot_ariel_projects.hoteleria.service;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.ActualizarReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.DetallesDeReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.RegistroReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IReservaService {

    DetallesDeReserva obtener(Long idReserva);
    Page<DetallesDeReserva> obtenerListaReserva(Pageable pageable);
    DetallesDeReserva registrar(RegistroReserva registroReserva);
    DetallesDeReserva actualizar(ActualizarReserva actualizarReserva, Long reservaId);
    void eliminar(Long idReserva);


}
