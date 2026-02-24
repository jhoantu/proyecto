package com.utc.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.proyecto.entity.ActividadAccion;

public interface ActividadAccionRepository
        extends JpaRepository<ActividadAccion, Long> {
}