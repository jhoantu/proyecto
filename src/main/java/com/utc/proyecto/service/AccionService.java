package com.utc.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utc.proyecto.entity.Accion;
import com.utc.proyecto.repository.AccionRepository;

@Service
public class AccionService {

    private final AccionRepository repo;

    public AccionService(AccionRepository repo) {
        this.repo = repo;
    }

    public List<Accion> listar() {
        return repo.findAll();
    }

    public void guardar(Accion accion) {
        repo.save(accion);
    }

    public Accion buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}