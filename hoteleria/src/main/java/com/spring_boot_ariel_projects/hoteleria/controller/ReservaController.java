package com.spring_boot_ariel_projects.hoteleria.controller;

import com.spring_boot_ariel_projects.hoteleria.model.reserva.ActualizarReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.DetallesDeReserva;
import com.spring_boot_ariel_projects.hoteleria.model.reserva.RegistroReserva;
import com.spring_boot_ariel_projects.hoteleria.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reserva")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping("/crear")
    public ResponseEntity<DetallesDeReserva> registrarReserva(@RequestBody @Valid RegistroReserva nuevaReserva){

        var reserva = reservaService.registrar(nuevaReserva);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(reserva);
    }

    @GetMapping("/obtener/{reservaId}")
    public ResponseEntity<DetallesDeReserva> obtenerReservaPorId(@PathVariable Long reservaId){
        var reserva = reservaService.obtener(reservaId);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(reserva);
    }

    @GetMapping("/obtener/todas")
    public ResponseEntity<Page<DetallesDeReserva>> listaDeReservas(Pageable pagination){
        return ResponseEntity.ok(reservaService.obtenerListaReserva(pagination));
    }

    @PutMapping("/actualizar/{reservaId}")
    public ResponseEntity<DetallesDeReserva> actualizarReserva(@RequestBody @Valid ActualizarReserva actualizar,@PathVariable Long reservaId){
        var reserva = reservaService.actualizar(actualizar, reservaId);
        return ResponseEntity.ok().body(reserva);
    }

    @DeleteMapping("/eliminar/{reservaId}")
    public ResponseEntity<Void> eliminarReserva(Long reservaId){
        reservaService.eliminar(reservaId);
        return ResponseEntity.noContent().build();
    }



}
