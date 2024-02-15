package com.example.demo.controller;


import com.example.demo.models.Proyecto;
import com.example.demo.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    // Crear proyecto
    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.crearProyecto(proyecto);
    }

    // Editar proyecto
    @PutMapping("/{id}")
    public Proyecto editarProyecto(@PathVariable int id, @RequestBody Proyecto proyecto) {
        return proyectoService.editarProyecto(id, proyecto);
    }

    // Borrar proyecto
    @DeleteMapping("/{id}")
    public void borrarProyecto(@PathVariable int id) {
        proyectoService.borrarProyecto(id);
    }

    // Ver un solo proyecto
    @GetMapping("/{id}")
    public Proyecto verProyecto(@PathVariable int id) {
        return proyectoService.buscarPorId(id);
    }

    // Ver todos los proyectos
    @GetMapping
    public List<Proyecto> verTodosLosProyectos() {
        return proyectoService.buscarTodos();
    }

    // Usuario se inscribe en proyecto
    @PostMapping("/{proyectoId}/inscribir/{usuarioId}")
    public void inscribirUsuarioAProyecto(@PathVariable int proyectoId, @PathVariable int usuarioId) {
        proyectoService.inscribirUsuario(proyectoId, usuarioId);
    }

    // Usuario sale de proyecto
    @DeleteMapping("/{proyectoId}/desinscribir/{usuarioId}")
    public void desinscribirUsuarioDeProyecto(@PathVariable int proyectoId, @PathVariable int usuarioId) {
        proyectoService.desinscribirUsuario(proyectoId, usuarioId);
    }
}