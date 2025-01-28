package com.espe.equipos.repositories;

import com.espe.equipos.models.entities.EquipoMiembro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EquipoMiembroRepository extends JpaRepository<EquipoMiembro, Long> {


    List<EquipoMiembro> findByMiembroId(Long miembroId);

    List<EquipoMiembro> findByEquipoId(Long equipoId);
}
