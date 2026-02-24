package com.utc.proyecto.entity;

import java.time.LocalDateTime;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "actividad_accion")
public class ActividadAccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_actividad")
    private Long codigoActividad;

    @Column(name = "numero_actividad")
    private Integer numeroActividad;

    @Column(name = "fecha_ini_actividad")
    private LocalDate fechaIniActividad;

    @Column(name = "fecha_max_actividad")
    private LocalDate fechaMaxActividad;

    @Column(name = "estado_actividad", length = 255)
    private String estadoActividad;

    @Column(name = "fecha_creado_actividad")
    private LocalDateTime fechaCreadoActividad;

    @Column(name = "fecha_editado_actividad")
    private LocalDateTime fechaEditadoActividad;

    // 🔗 RELACIÓN CON ACCION
    @ManyToOne
    @JoinColumn(name = "fk_cod_accion", referencedColumnName = "codigo_accion")
    private Accion accion;

    // 🔹 Constructor vacío obligatorio
    public ActividadAccion() {
        this.estadoActividad = "ABIERTO"; // valor por defecto
    }

    // 🔹 Constructor útil
    public ActividadAccion(Integer numeroActividad, LocalDate fechaIniActividad, LocalDate fechaMaxActividad) {
        this.numeroActividad = numeroActividad;
        this.fechaIniActividad = fechaIniActividad;
        this.fechaMaxActividad = fechaMaxActividad;
        this.estadoActividad = "ABIERTO";
    }

    // 🔹 Getters y Setters
    public Long getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(Long codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Integer getNumeroActividad() {
        return numeroActividad;
    }

    public void setNumeroActividad(Integer numeroActividad) {
        this.numeroActividad = numeroActividad;
    }

    public LocalDate getFechaIniActividad() {
        return fechaIniActividad;
    }

    public void setFechaIniActividad(LocalDate fechaIniActividad) {
        this.fechaIniActividad = fechaIniActividad;
    }

    public LocalDate getFechaMaxActividad() {
        return fechaMaxActividad;
    }

    public void setFechaMaxActividad(LocalDate fechaMaxActividad) {
        this.fechaMaxActividad = fechaMaxActividad;
    }

    public String getEstadoActividad() {
        return estadoActividad;
    }

    public void setEstadoActividad(String estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public LocalDateTime getFechaCreadoActividad() {
        return fechaCreadoActividad;
    }

    public LocalDateTime getFechaEditadoActividad() {
        return fechaEditadoActividad;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    // 🔹 Inicializa fechas automáticamente al guardar
    @PrePersist
    public void prePersist() {
        this.fechaCreadoActividad = LocalDateTime.now();
        this.fechaEditadoActividad = LocalDateTime.now();
        if (this.estadoActividad == null) {
            this.estadoActividad = "ABIERTO";
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaEditadoActividad = LocalDateTime.now();
    }
}