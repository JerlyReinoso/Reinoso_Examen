package controller;

import model.Miembro;
import service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miembros")
public class MiembroController {
    @Autowired
    private MiembroService miembroService;

    @PostMapping
    public Miembro crearMiembro(@RequestBody Miembro miembro) {
        return miembroService.crearMiembro(miembro);
    }

    @GetMapping
    public List<Miembro> listarMiembros() {
        return miembroService.listarMiembros();
    }
}
