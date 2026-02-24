package com.utc.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.proyecto.entity.Accion;

public interface AccionRepository extends JpaRepository<Accion, Long> {
}