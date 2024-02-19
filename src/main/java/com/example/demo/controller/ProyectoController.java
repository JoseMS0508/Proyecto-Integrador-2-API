package com.example.demo.controller;

import com.example.demo.models.Proyecto;
import com.example.demo.models.Skill;
import com.example.demo.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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
    @GetMapping("/todos")
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

    // Endpoint para añadir habilidades solicitadas a un proyecto
    @PutMapping("/{proyectoId}/habilidades")
    public ResponseEntity<?> añadirHabilidadesAProyecto(@PathVariable int proyectoId, @RequestBody Set<Integer> idsHabilidades) {
        proyectoService.añadirHabilidadesAProyecto(proyectoId, idsHabilidades);
        return ResponseEntity.ok().build();
    }

    // Nuevo endpoint para obtener las skills de un proyecto específico
    @GetMapping("/{idProyecto}/skills")
    public ResponseEntity<Set<Skill>> obtenerSkillsDeProyecto(@PathVariable int idProyecto) {
        Set<Skill> skills = proyectoService.obtenerSkillsDeProyecto(idProyecto);
        if (skills != null && !skills.isEmpty()) {
            return new ResponseEntity<>(skills, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
