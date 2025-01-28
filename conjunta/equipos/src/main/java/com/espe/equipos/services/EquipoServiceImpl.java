package com.espe.equipos.services;

import com.espe.equipos.models.Miembro;
import com.espe.equipos.models.entities.Equipo;
import com.espe.equipos.models.entities.EquipoMiembro;
import com.espe.equipos.repositories.EquipoMiembroRepository;
import com.espe.equipos.repositories.EquipoRepository;
import com.espe.equipos.clients.MiembroClientRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServiceImpl implements EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private EquipoMiembroRepository equipoMiembroRepository;

    @Autowired
    private MiembroClientRest miembroClientRest;

    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> findById(Long id) {
        return equipoRepository.findById(id);
    }

    @Override
    public List<Miembro> findMiembrosByEquipo(Long equipoId) {
        List<EquipoMiembro> asignaciones = equipoMiembroRepository.findByEquipoId(equipoId);
        List<Miembro> miembros = new ArrayList<>();
        for (EquipoMiembro asignacion : asignaciones) {
            Miembro miembro = miembroClientRest.findById(asignacion.getMiembroId());
            miembros.add(miembro);
        }
        return miembros;
    }

    @Override
    public List<Equipo> findEquiposByMiembro(Long miembroId) {
        List<EquipoMiembro> asignaciones = equipoMiembroRepository.findByMiembroId(miembroId);
        List<Equipo> equipos = new ArrayList<>();
        for (EquipoMiembro asignacion : asignaciones) {
            equipos.add(asignacion.getEquipo());
        }
        return equipos;
    }

    @Override
    public void addMiembroToEquipo(Long equipoId, Miembro miembro) {
        Equipo equipo = equipoRepository.findById(equipoId)
                .orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
        EquipoMiembro asignacion = new EquipoMiembro();
        asignacion.setEquipo(equipo);
        asignacion.setMiembroId(miembro.getId()); // Utilizamos el ID del miembro recibido
        equipoMiembroRepository.save(asignacion);
    }


    @Override
    public void removeMiembroFromEquipo(Long equipoId, Long miembroId) {
        List<EquipoMiembro> asignaciones = equipoMiembroRepository.findByEquipoId(equipoId);
        asignaciones.stream()
                .filter(a -> a.getMiembroId().equals(miembroId))
                .findFirst()
                .ifPresent(equipoMiembroRepository::delete);
    }
}
