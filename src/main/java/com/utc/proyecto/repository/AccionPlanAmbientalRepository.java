package com.utc.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.proyecto.entity.AccionPlanAmbiental;

public interface AccionPlanAmbientalRepository
        extends JpaRepository<AccionPlanAmbiental, Long> {
}