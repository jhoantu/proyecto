package com.utc.proyecto.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "accion")
public class Accion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_accion")
    private Long codigoAccion;

    @Column(name = "fecha_creacion_accion")
    private LocalDateTime fechaCreacionAccion;

    @Column(name = "accion_accion", length = 50)
    private String accionAccion;

    @Column(name = "detalle_anterior_accion", columnDefinition = "TEXT")
    private String detalleAnteriorAccion;

    @Column(name = "detalle_actual_accion", columnDefinition = "TEXT")
    private String detalleActualAccion;

    @Column(name = "tabla_accion", length = 100)
    private String tablaAccion;

    @Column(name = "modulo_accion", length = 100)
    private String moduloAccion;

    @Column(name = "codigo_usu_accion")
    private Long codigoUsuAccion;

    @Column(name = "email_usu_accion", length = 500)
    private String emailUsuAccion;

    @Column(name = "usuario_usu_accion", length = 500)
    private String usuarioUsuAccion;

    // 🔹 Constructor vacío obligatorio
    public Accion() {
    }

    // 🔹 Constructor con campos principales
    public Accion(String accionAccion, String tablaAccion, String moduloAccion) {
        this.accionAccion = accionAccion;
        this.tablaAccion = tablaAccion;
        this.moduloAccion = moduloAccion;
    }

    // 🔹 Getters y Setters
    public Long getCodigoAccion() {
        return codigoAccion;
    }

    public void setCodigoAccion(Long codigoAccion) {
        this.codigoAccion = codigoAccion;
    }

    public LocalDateTime getFechaCreacionAccion() {
        return fechaCreacionAccion;
    }

    public void setFechaCreacionAccion(LocalDateTime fechaCreacionAccion) {
        this.fechaCreacionAccion = fechaCreacionAccion;
    }

    public String getAccionAccion() {
        return accionAccion;
    }

    public void setAccionAccion(String accionAccion) {
        this.accionAccion = accionAccion;
    }

    public String getDetalleAnteriorAccion() {
        return detalleAnteriorAccion;
    }

    public void setDetalleAnteriorAccion(String detalleAnteriorAccion) {
        this.detalleAnteriorAccion = detalleAnteriorAccion;
    }

    public String getDetalleActualAccion() {
        return detalleActualAccion;
    }

    public void setDetalleActualAccion(String detalleActualAccion) {
        this.detalleActualAccion = detalleActualAccion;
    }

    public String getTablaAccion() {
        return tablaAccion;
    }

    public void setTablaAccion(String tablaAccion) {
        this.tablaAccion = tablaAccion;
    }

    public String getModuloAccion() {
        return moduloAccion;
    }

    public void setModuloAccion(String moduloAccion) {
        this.moduloAccion = moduloAccion;
    }

    public Long getCodigoUsuAccion() {
        return codigoUsuAccion;
    }

    public void setCodigoUsuAccion(Long codigoUsuAccion) {
        this.codigoUsuAccion = codigoUsuAccion;
    }

    public String getEmailUsuAccion() {
        return emailUsuAccion;
    }

    public void setEmailUsuAccion(String emailUsuAccion) {
        this.emailUsuAccion = emailUsuAccion;
    }

    public String getUsuarioUsuAccion() {
        return usuarioUsuAccion;
    }

    public void setUsuarioUsuAccion(String usuarioUsuAccion) {
        this.usuarioUsuAccion = usuarioUsuAccion;
    }
}