package com.espe.miembros.services;

import com.espe.miembros.models.entities.Miembro;
import com.espe.miembros.repositories.MiembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiembroServiceImpl implements MiembroService {

    @Autowired
    private MiembroRepository repository;

    @Override
    public List<Miembro> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Miembro> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Miembro save(Miembro miembro) {
        return repository.save(miembro);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
