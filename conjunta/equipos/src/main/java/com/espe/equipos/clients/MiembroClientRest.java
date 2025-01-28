package com.espe.equipos.clients;

import com.espe.equipos.models.Miembro;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "miembros", url = "http://localhost:8003/api/miembros")
public interface MiembroClientRest {

    @GetMapping("/{id}")
    Miembro findById(@PathVariable Long id);
}
