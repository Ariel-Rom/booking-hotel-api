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

import java.time.LocalDate;
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
    private Long hotelId;
    @FutureOrPresent
    @NotNull
    private LocalDate diaIngreso;
    @FutureOrPresent
    @NotNull
    private LocalDate diaEgreso;
    @Min(1)
    @NotNull
    private Long cantidadHuespedes;
    private Boolean activo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

    public Reserva(RegistroReserva registroReserva){
        this.diaIngreso = registroReserva.diaIngreso();
        this.diaEgreso = registroReserva.diaEgreso();
        this.cantidadHuespedes = registroReserva.cantidadHuespedes();
        this.userId = registroReserva.userId();
        this.hotelId = registroReserva.hotelId();
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

        LocalDate ingreso = actualizarReserva.diaIngreso() != null ? actualizarReserva.diaIngreso() : this.diaIngreso;
        LocalDate egreso = actualizarReserva.diaEgreso() != null? actualizarReserva.diaEgreso() : this.diaEgreso;

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

    public void desactivar(){
        this.activo = false;
    }



}
