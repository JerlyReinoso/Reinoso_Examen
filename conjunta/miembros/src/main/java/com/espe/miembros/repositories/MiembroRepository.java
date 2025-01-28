package com.espe.miembros.repositories;

import com.espe.miembros.models.entities.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembro, Long> {
}
