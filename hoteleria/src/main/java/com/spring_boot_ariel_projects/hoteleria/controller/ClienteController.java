package com.spring_boot_ariel_projects.hoteleria.controller;

import com.spring_boot_ariel_projects.hoteleria.model.cliente.ActualizarCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.DetallesDeCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.RegistroDeDatosCliente;
import com.spring_boot_ariel_projects.hoteleria.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/registrar")
    public ResponseEntity<DetallesDeCliente> registrarCliente(@RequestBody @Valid RegistroDeDatosCliente registroDeDatosCliente){
        var cliente = clienteService.registrar(registroDeDatosCliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/obtener/{clienteId}")
    public ResponseEntity<DetallesDeCliente> obtenerClientePorId(@PathVariable Long clienteId){
        var cliente = clienteService.obtener(clienteId);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/obtener/todos")
    public ResponseEntity<Page<DetallesDeCliente>> listaDeClientes(Pageable pagination){
        return ResponseEntity.ok(clienteService.obtenerListaCliente(pagination));
    }

    @PutMapping("/actualizar/{clienteId}")
    public ResponseEntity<DetallesDeCliente> actualizarReserva(@RequestBody @Valid ActualizarCliente actualizar, @PathVariable Long clienteId){
        var cliente = clienteService.actualizar(actualizar, clienteId);
        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/eliminar/{clienteId}")
    public ResponseEntity<Void> eliminarCliente(Long clienteId){
        clienteService.eliminar(clienteId);
        return ResponseEntity.noContent().build();
    }

}
