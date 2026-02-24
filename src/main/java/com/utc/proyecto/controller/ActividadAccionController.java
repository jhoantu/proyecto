package com.utc.proyecto.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.utc.proyecto.entity.ActividadAccion;
import com.utc.proyecto.service.ActividadAccionService;
import com.utc.proyecto.service.AccionService;

@Controller
@RequestMapping("/actividad-accion")
public class ActividadAccionController {

    private final ActividadAccionService service;
    private final AccionService accionService;

    public ActividadAccionController(ActividadAccionService service, AccionService accionService) {
        this.service = service;
        this.accionService = accionService;
    }

    // LISTAR
    @GetMapping
    public String listar(Model model, @RequestParam(required = false) String error) {
        model.addAttribute("listaActividades", service.listar());
        if ("true".equals(error)) model.addAttribute("errorRelacion", true);
        return "actividadaccion/actividadaccion"; // Asegúrate de tener este template
    }

    // FORMULARIO NUEVO
    @GetMapping("/crear")
    public String nuevo(Model model) {
        model.addAttribute("actividadAccion", new ActividadAccion());
        model.addAttribute("listaAcciones", accionService.listar());
        return "actividadaccion/crear";
    }

    // GUARDAR (nuevo / editar)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute ActividadAccion actividadAccion) {
        service.guardar(actividadAccion);
        return "redirect:/actividad-accion";
    }

    // FORMULARIO EDITAR
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        ActividadAccion actividad = service.buscarPorId(id);
        model.addAttribute("actividadAccion", actividad);
        model.addAttribute("listaAcciones", accionService.listar());
        return "actividadaccion/crear";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
        } catch (DataIntegrityViolationException e) {
            return "redirect:/actividad-accion?error=true";
        }
        return "redirect:/actividad-accion";
    }
}