package com.utc.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utc.proyecto.entity.AccionPlanAmbiental;
import com.utc.proyecto.repository.AccionPlanAmbientalRepository;

@Service
public class AccionPlanAmbientalService {

    private final AccionPlanAmbientalRepository repo;

    public AccionPlanAmbientalService(AccionPlanAmbientalRepository repo) {
        this.repo = repo;
    }

    public List<AccionPlanAmbiental> listar() {
        return repo.findAll();
    }

    public void guardar(AccionPlanAmbiental accionPlanAmbiental) {
        repo.save(accionPlanAmbiental);
    }

    public AccionPlanAmbiental buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}