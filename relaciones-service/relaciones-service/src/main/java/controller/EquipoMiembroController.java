package controller;

import model.EquipoMiembro;
import service.EquipoMiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relaciones")
public class EquipoMiembroController {
    @Autowired
    private EquipoMiembroService service;

    @PostMapping
    public EquipoMiembro agregarMiembroAEquipo(@RequestBody EquipoMiembro equipoMiembro) {
        return service.agregarMiembroAEquipo(equipoMiembro);
    }

    @GetMapping("/equipo/{equipoId}")
    public List<EquipoMiembro> listarMiembrosDeEquipo(@PathVariable Long equipoId) {
        return service.listarMiembrosDeEquipo(equipoId);
    }

    @GetMapping("/miembro/{miembroId}")
    public List<EquipoMiembro> listarEquiposDeMiembro(@PathVariable Long miembroId) {
        return service.listarEquiposDeMiembro(miembroId);
    }

    @DeleteMapping("/{id}")
    public void eliminarRelacion(@PathVariable Long id) {
        service.eliminarRelacion(id);
    }
}
