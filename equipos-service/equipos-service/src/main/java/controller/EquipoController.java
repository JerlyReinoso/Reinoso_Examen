package controller;

import model.Equipo;
import service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {
    @Autowired
    private EquipoService equipoService;

    @PostMapping
    public Equipo crearEquipo(@RequestBody Equipo equipo) {
        return equipoService.crearEquipo(equipo);
    }

    @GetMapping
    public List<Equipo> listarEquipos() {
        return equipoService.listarEquipos();
    }
}
