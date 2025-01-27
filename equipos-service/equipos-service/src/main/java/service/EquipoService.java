package service;

import model.Equipo;
import repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EquipoService {
    @Autowired
    private EquipoRepository equipoRepository;

    public Equipo crearEquipo(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listarEquipos() {
        return equipoRepository.findAll();
    }
}
