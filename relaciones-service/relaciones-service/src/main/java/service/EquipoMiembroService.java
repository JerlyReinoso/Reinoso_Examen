package service;

import model.EquipoMiembro;
import repository.EquipoMiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoMiembroService {
    @Autowired
    private EquipoMiembroRepository repository;

    public EquipoMiembro agregarMiembroAEquipo(EquipoMiembro equipoMiembro) {
        return repository.save(equipoMiembro);
    }

    public List<EquipoMiembro> listarMiembrosDeEquipo(Long equipoId) {
        return repository.findByEquipoId(equipoId);
    }

    public List<EquipoMiembro> listarEquiposDeMiembro(Long miembroId) {
        return repository.findByMiembroId(miembroId);
    }

    public void eliminarRelacion(Long id) {
        repository.deleteById(id);
    }
}
