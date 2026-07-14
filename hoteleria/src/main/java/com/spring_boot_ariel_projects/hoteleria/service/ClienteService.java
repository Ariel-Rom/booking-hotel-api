package com.spring_boot_ariel_projects.hoteleria.service;


import com.spring_boot_ariel_projects.hoteleria.model.cliente.ActualizarCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.Cliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.DetallesDeCliente;
import com.spring_boot_ariel_projects.hoteleria.model.cliente.RegistroDeDatosCliente;
import com.spring_boot_ariel_projects.hoteleria.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService implements IClienteService{

    private final ClienteRepository clienteRepository;

    @Override
    public DetallesDeCliente registrar(RegistroDeDatosCliente registroDeDatosCliente) {

        var nuevoCliente = new Cliente(registroDeDatosCliente);
        clienteRepository.save(nuevoCliente);

        return new DetallesDeCliente(nuevoCliente);

    }

    @Override
    public DetallesDeCliente obtener(Long clienteId) {

        var cliente = getClienteOrThrow(clienteId);
        return new DetallesDeCliente(cliente);

    }

    @Override
    public Page<DetallesDeCliente> obtenerListaCliente(Pageable pageable) {

        return clienteRepository.findClienteByActivoTrue(pageable).map(DetallesDeCliente::new);

    }

    @Override
    public DetallesDeCliente actualizar(ActualizarCliente actualizarCliente, Long clienteId) {

        var actualizar = getClienteOrThrow(clienteId);
        actualizar.actualizarCliente(actualizarCliente);
        clienteRepository.save(actualizar);

        return new DetallesDeCliente(actualizar);

    }

    @Override
    public void eliminar(Long clienteId) {
       var cliente = getClienteOrThrow(clienteId);
       clienteRepository.delete(cliente);
    }

    private Cliente getClienteOrThrow(Long clienteId){
        return clienteRepository.findClienteByActivoTrue(clienteId).orElseThrow(()->
                new EntityNotFoundException("Cliente no encontrado"));
    }

}
