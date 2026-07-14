package com.spring_boot_ariel_projects.hoteleria.repository;

import com.spring_boot_ariel_projects.hoteleria.model.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
