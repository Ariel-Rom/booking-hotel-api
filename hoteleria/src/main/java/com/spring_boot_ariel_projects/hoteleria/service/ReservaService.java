package com.spring_boot_ariel_projects.hoteleria.service;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.ActualizarReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.DetallesDeReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.RegistroReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.Reserva;
import com.spring_boot_ariel_projects.hoteleria.repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService{

    private final ReservaRepository reservaRepository;

    @Override
    public DetallesDeReserva obtener(Long idReserva) {
        Reserva reserva = reservaRepository.findById(idReserva).orElseThrow
                (() -> new IllegalArgumentException("Reserva no encontrada"));
        return new DetallesDeReserva(reserva);
    }

    @Override
    public List<DetallesDeReserva> obtenerListaReserva() {
        return List.of();
    }

    @Override
    public DetallesDeReserva registrar(RegistroReserva registroReserva) {
        return null;
    }

    @Override
    public DetallesDeReserva actualizar(ActualizarReserva actualizarReserva) {
        return null;
    }

    @Override
    public void eliminar(Long idReserva) {

    }
}
