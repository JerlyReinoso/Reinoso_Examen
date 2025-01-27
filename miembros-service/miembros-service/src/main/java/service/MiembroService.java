package service;

import model.Miembro;
import repository.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MiembroService {
    @Autowired
    private MiembroRepository miembroRepository;

    public Miembro crearMiembro(Miembro miembro) {
        return miembroRepository.save(miembro);
    }

    public List<Miembro> listarMiembros() {
        return miembroRepository.findAll();
    }
}
