package com.spring_boot_ariel_projects.hoteleria.repository;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
