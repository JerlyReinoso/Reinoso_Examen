package com.espe.equipos.repositories;

import com.espe.equipos.models.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
}
