package com.example.demo.controller;

import com.example.demo.models.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills") // Ajusta la ruta según tu estructura de API
public class SkillController {

    @Autowired
    private SkillService skillService;

    // Añadir una nueva habilidad
    @PostMapping
    public Skill añadirSkill(@RequestBody Skill skill) {
        return skillService.añadirSkill(skill);
    }

    // Eliminar una habilidad por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarSkill(@PathVariable int id) {
        skillService.eliminarSkill(id);
        return ResponseEntity.ok().build();
    }

    // Modificar una habilidad existente
    @PutMapping("/{id}")
    public Skill modificarSkill(@PathVariable int id, @RequestBody Skill skillDetalles) {
        return skillService.modificarSkill(id, skillDetalles);
    }

    // Buscar una habilidad por ID
    @GetMapping("/{id}")
    public Skill buscarPorId(@PathVariable int id) {
        return skillService.buscarPorId(id);
    }

    // Listar todas las habilidades
    @GetMapping("/todas")
    public List<Skill> listarSkills() {
        return skillService.listarSkills();
    }
}
