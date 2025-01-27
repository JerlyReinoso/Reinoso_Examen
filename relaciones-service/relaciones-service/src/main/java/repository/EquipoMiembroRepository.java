package repository;

import model.EquipoMiembro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoMiembroRepository extends JpaRepository<EquipoMiembro, Long> {
    List<EquipoMiembro> findByEquipoId(Long equipoId);
    List<EquipoMiembro> findByMiembroId(Long miembroId);
}
