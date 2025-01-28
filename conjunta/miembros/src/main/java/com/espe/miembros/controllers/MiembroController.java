package com.espe.miembros.controllers;

import com.espe.miembros.models.entities.Miembro;
import com.espe.miembros.services.MiembroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/miembros")
public class MiembroController {

    @Autowired
    private MiembroService service;

    @GetMapping
    public List<Miembro> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Miembro> miembro = service.findById(id);
        if (miembro.isPresent()) {
            return ResponseEntity.ok(miembro.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", "Miembro no encontrado"));
        }
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Miembro miembro, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(miembro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Miembro miembro, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
        }

        return service.findById(id).map(miembroExistente -> {
            miembroExistente.setNombre(miembro.getNombre());
            miembroExistente.setApellido(miembro.getApellido());
            miembroExistente.setEmail(miembro.getEmail());
            miembroExistente.setTelefono(miembro.getTelefono());
            miembroExistente.setFechaNacimiento(miembro.getFechaNacimiento());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(miembroExistente));
        }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body((Miembro) Map.of("mensaje", "Miembro no encontrado")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("mensaje", "Miembro no encontrado"));
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
