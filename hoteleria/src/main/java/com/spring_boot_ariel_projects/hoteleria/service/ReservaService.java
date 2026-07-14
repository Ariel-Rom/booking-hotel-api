package com.spring_boot_ariel_projects.hoteleria.service;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.ActualizarReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.DetallesDeReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.RegistroReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.Reserva;
import com.spring_boot_ariel_projects.hoteleria.repository.ReservaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservaService implements IReservaService{

    private final ReservaRepository reservaRepository;

    @Override
    public DetallesDeReserva obtener(Long reservaId) {
        var reserva = getReservaOrThrow(reservaId);
        return new DetallesDeReserva(reserva);
    }

    @Override
    public Page<DetallesDeReserva> obtenerListaReserva(Pageable pageable) {
        return reservaRepository.findReservaByActivoTrue(pageable)
                .map(DetallesDeReserva::new);
    }

    @Override
    public DetallesDeReserva registrar(RegistroReserva registroReserva) {
        var nuevaReserva = new Reserva(registroReserva);
        reservaRepository.save(nuevaReserva);
        return new DetallesDeReserva(nuevaReserva);
    }

    @Override
    public DetallesDeReserva actualizar(ActualizarReserva actualizarReserva, Long reservaId) {
        var reserva = getReservaOrThrow(reservaId);
        reserva.actualizarDatos(actualizarReserva);
        return new DetallesDeReserva(reserva);
    }

    @Override
    public void eliminar(Long reservaId) {
        var reserva = getReservaOrThrow(reservaId);
        reserva.desactivar();
    }

    private Reserva getReservaOrThrow(Long reservaId){
        return reservaRepository.findReservaByActivoTrue(reservaId).orElseThrow(
                () -> new EntityNotFoundException("Reserva no encontrada!"));
    }
}
