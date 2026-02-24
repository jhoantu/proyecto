package com.utc.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utc.proyecto.entity.ActividadAccion;
import com.utc.proyecto.repository.ActividadAccionRepository;

@Service
public class ActividadAccionService {

    private final ActividadAccionRepository repo;

    public ActividadAccionService(ActividadAccionRepository repo) {
        this.repo = repo;
    }

    public List<ActividadAccion> listar() {
        return repo.findAll();
    }

    public void guardar(ActividadAccion actividadAccion) {
        repo.save(actividadAccion);
    }

    public ActividadAccion buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}