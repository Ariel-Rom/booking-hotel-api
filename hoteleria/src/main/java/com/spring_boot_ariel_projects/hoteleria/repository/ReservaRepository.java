package com.spring_boot_ariel_projects.hoteleria.repository;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.Reserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    Page<Reserva> findReservaByActivoTrue(Pageable pagination);
    Optional<Reserva> findReservaByActivoTrue(Long id);
}
