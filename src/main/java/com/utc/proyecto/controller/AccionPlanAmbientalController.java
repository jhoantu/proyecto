package com.utc.proyecto.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.utc.proyecto.entity.AccionPlanAmbiental;
import com.utc.proyecto.service.AccionPlanAmbientalService;
import com.utc.proyecto.service.AccionService; // servicio para listar Acciones

@Controller
public class AccionPlanAmbientalController {

    private final AccionPlanAmbientalService service;
    private final AccionService accionService; // para traer lista de acciones

    public AccionPlanAmbientalController(AccionPlanAmbientalService service, AccionService accionService) {
        this.service = service;
        this.accionService = accionService;
    }

    // LISTAR
    @GetMapping("/accion-plan-ambiental")
    public String listar(Model model, String error) {
        model.addAttribute("listaAccionesAmbientales", service.listar());
        if ("true".equals(error)) {
            model.addAttribute("errorRelacion", true);
        }
        // Apunta al template: src/main/resources/templates/accionplanambiental/accionplanambiental.html
        return "accionplanambiental/accionplanambiental"; 
    }

    // FORMULARIO NUEVO
    @GetMapping("/accion-plan-ambiental/crear")
    public String nuevo(Model model) {
        model.addAttribute("accionPlanAmbiental", new AccionPlanAmbiental());
        model.addAttribute("listaAcciones", accionService.listar()); // cargamos acciones para el select
        // Apunta al template: src/main/resources/templates/accionplanambiental/crear.html
        return "accionplanambiental/crear";
    }

    // GUARDAR (nuevo / editar)
    @PostMapping("/accion-plan-ambiental/guardar")
    public String guardar(@ModelAttribute AccionPlanAmbiental accionPlanAmbiental) {
        service.guardar(accionPlanAmbiental);
        return "redirect:/accion-plan-ambiental";
    }

    // FORMULARIO EDITAR
    @GetMapping("/accion-plan-ambiental/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        AccionPlanAmbiental accion = service.buscarPorId(id);
        model.addAttribute("accionPlanAmbiental", accion);
        model.addAttribute("listaAcciones", accionService.listar()); // cargamos acciones para el select
        // Reusa el template crear.html para editar
        return "accionplanambiental/crear";
    }

    // ELIMINAR
    @GetMapping("/accion-plan-ambiental/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        try {
            service.eliminar(id);
            return "redirect:/accion-plan-ambiental";
        } catch (DataIntegrityViolationException e) {
            // Si existe relación, redirige con parámetro de error
            return "redirect:/accion-plan-ambiental?error=true";
        }
    }
}