package com.espe.equipos.models.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "equipo")  // Asocia el "mappedBy" para indicar la relación inversa
    @JsonManagedReference  // Controla la serialización del lado "administrado"
    private List<EquipoMiembro> equipoMiembros = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public List<EquipoMiembro> getEquipoMiembros() {
        return equipoMiembros;
    }

    public void setEquipoMiembros(List<EquipoMiembro> equipoMiembros) {
        this.equipoMiembros = equipoMiembros;
    }
}

