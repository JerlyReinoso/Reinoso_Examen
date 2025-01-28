package com.espe.equipos.controllers;

import com.espe.equipos.models.Miembro;
import com.espe.equipos.models.entities.Equipo;
import com.espe.equipos.services.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService servicio;

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Equipo equipo) {
        return ResponseEntity.ok(servicio.save(equipo));
    }

    @GetMapping
    public ResponseEntity<List<Equipo>> listar() {
        return ResponseEntity.ok(servicio.findAll());
    }

    @PostMapping("/{id}/miembros")
    public ResponseEntity<?> agregarMiembro(@PathVariable Long id, @RequestBody Miembro miembro) {
        servicio.addMiembroToEquipo(id, miembro);
        // Respuesta con mensaje de éxito
        Map<String, String> response = new HashMap<>();
        response.put("message", "Miembro agregado exitosamente.");
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}/miembros/{miembroId}")
    public ResponseEntity<?> eliminarMiembro(@PathVariable Long id, @PathVariable Long miembroId) {
        servicio.removeMiembroFromEquipo(id, miembroId);
        // Respuesta con mensaje de éxito
        Map<String, String> response = new HashMap<>();
        response.put("message", "Miembro eliminado exitosamente.");
        return ResponseEntity.ok(response);
    }


    // Listar equipos por miembro
    @GetMapping("/miembros/{miembroId}")
    public ResponseEntity<List<Equipo>> listarEquiposPorMiembro(@PathVariable Long miembroId) {
        return ResponseEntity.ok(servicio.findEquiposByMiembro(miembroId));
    }

    // Listar miembros por equipo
    @GetMapping("/{id}/miembros")
    public ResponseEntity<List<Miembro>> listarMiembros(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.findMiembrosByEquipo(id));
    }



}
