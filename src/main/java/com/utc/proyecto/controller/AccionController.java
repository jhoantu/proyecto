package com.utc.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.utc.proyecto.entity.Accion;
import com.utc.proyecto.service.AccionService;

@Controller
public class AccionController {

    private final AccionService service;

    public AccionController(AccionService service) {
        this.service = service;
    }

    // ================= LISTAR =================
    @GetMapping("/acciones")
    public String listar(Model model) {
        model.addAttribute("listaAcciones", service.listar());
        return "accion/accion";
    }

    // ================= NUEVO =================
    @GetMapping("/acciones/crear")
    public String nuevo(Model model) {
        model.addAttribute("accion", new Accion());
        return "accion/crear";
    }

    // ================= GUARDAR =================
    @PostMapping("/acciones/guardar")
    public String guardar(@ModelAttribute Accion accion) {
        service.guardar(accion);
        return "redirect:/acciones";
    }

    // ================= EDITAR =================
    @GetMapping("/acciones/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Accion accion = service.buscarPorId(id);
        model.addAttribute("accion", accion);
        return "accion/crear";
    }

    // ================= ELIMINAR =================
    @GetMapping("/acciones/eliminar/{id}")
    public String eliminar(@PathVariable Long id, Model model) {
        try {
            service.eliminar(id);
            return "redirect:/acciones";
        } catch (Exception e) {
            // ⚠️ Error por relación (FK)
            model.addAttribute("errorRelacion", true);
            model.addAttribute("listaAcciones", service.listar());
            return "accion/accion";
        }
    }
}