package com.spring_boot_ariel_projects.hoteleria.model.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity(name = "Cliente")
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false, unique = true)
    private String dni;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean activo;

    public Cliente(RegistroDeDatosCliente registroDeDatosCliente){
        this.activo = true;
        this.nombre = registroDeDatosCliente.nombre();
        this.apellido = registroDeDatosCliente.apellido();
        this.dni = registroDeDatosCliente.dni();
    }

    public void actualizarCliente(ActualizarCliente actualizarCliente){

        if (!activo){
            throw  new IllegalArgumentException("No es posible actualizar los datos!");
        }

        if (actualizarCliente.nombre() != null && !actualizarCliente.nombre().isBlank()){
            this.nombre = actualizarCliente.nombre();
        }

        if (actualizarCliente.apellido() != null && !actualizarCliente.apellido().isBlank()){
            this.apellido = actualizarCliente.apellido();
        }

        if (actualizarCliente.dni() != null && !actualizarCliente.dni().isBlank()){
            this.dni = actualizarCliente.dni();
        }

    }

    public void desactivar(){
        this.activo = false;
    }

    @PrePersist
    void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

}
