package com.spring_boot_ariel_projects.hoteleria.model.reserva;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Entity(name = "Reserva")
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long hotelId;
    @NotBlank
    private String nombreCliente;
    @FutureOrPresent
    @NotNull
    private LocalDateTime diaIngreso;
    @FutureOrPresent
    @NotNull
    private LocalDateTime diaEgreso;
    @Min(1)
    @NotNull
    private Long cantidadHuespedes;
    private Boolean activo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

    public Reserva(RegistroReserva registroReserva){
        this.nombreCliente = registroReserva.nombreCliente();
        this.diaIngreso = registroReserva.diaIngreso();
        this.diaEgreso = registroReserva.diaEgreso();
        this.cantidadHuespedes = registroReserva.cantidadHuespedes();
        this.activo = true;
    }

    @PrePersist
    void onCreate(){
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate(){
        this.updatedAt = LocalDateTime.now();
    }

    public void actualizarDatos(ActualizarReserva actualizarReserva){
        if (!activo){
            throw new IllegalArgumentException("No se puede actualizar los datos!");
        }

        if (actualizarReserva.hotelId() != null){
            this.hotelId = actualizarReserva.hotelId();
        }

        if (actualizarReserva.nombreCliente() != null && !actualizarReserva.nombreCliente().isBlank()){
            this.nombreCliente = actualizarReserva.nombreCliente();
        }

        LocalDateTime ingreso = actualizarReserva.diaIngreso() != null ? actualizarReserva.diaIngreso() : this.diaIngreso;
        LocalDateTime egreso = actualizarReserva.diaEgreso() != null? actualizarReserva.diaEgreso() : this.diaEgreso;

        if (egreso.isBefore(ingreso)){
            throw new IllegalArgumentException("La fecha de egreso no puede ser anterior a la fecha de ingreso");
        }

        this.diaIngreso = ingreso;
        this.diaEgreso = egreso;

        if (actualizarReserva.cantidadHuespedes() != null){
            if (actualizarReserva.cantidadHuespedes() <= 0){
                throw new IllegalArgumentException("La cantidad de huespedes debe ser mayor a cero");
            }
            this.cantidadHuespedes = actualizarReserva.cantidadHuespedes();
        }
    }

    public void activar(){
        this.activo = true;
    }

    public void desactivar(){
        this.activo = false;
    }



}
