package com.espe.equipos.services;

import com.espe.equipos.models.Miembro;
import com.espe.equipos.models.entities.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {

    // Crear o actualizar un equipo
    Equipo save(Equipo equipo);

    // Listar todos los equipos
    List<Equipo> findAll();

    // Buscar un equipo por su ID
    Optional<Equipo> findById(Long id);

    // Listar los miembros de un equipo
    List<Miembro> findMiembrosByEquipo(Long equipoId);

    // Listar los equipos en los que participa un miembro
    List<Equipo> findEquiposByMiembro(Long miembroId);



    void addMiembroToEquipo(Long equipoId, Miembro miembro);

    // Eliminar un miembro de un equipo
    void removeMiembroFromEquipo(Long equipoId, Long miembroId);
}
