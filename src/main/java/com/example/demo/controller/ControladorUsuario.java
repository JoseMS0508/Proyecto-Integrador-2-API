package com.example.demo.controller;

import com.example.demo.models.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SkillService skillService;

    // Crear nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }

    // Modificar usuario
    @PutMapping("/{id}")
    public Usuario modificarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return usuarioService.modificarUsuario(id, usuario);
    }

    // Ver usuario
    @GetMapping("/{id}")
    public Usuario verUsuario(@PathVariable int id) {
        return usuarioService.buscarPorId(id);
    }

    // Endpoint para actualizar habilidades de un usuario
    @PutMapping("/{usuarioId}/habilidades")
    public ResponseEntity<?> actualizarHabilidadesUsuario(@PathVariable int usuarioId, @RequestBody Set<Integer> idsHabilidades) {
        usuarioService.actualizarHabilidadesUsuario(usuarioId, idsHabilidades);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        try {
            Usuario usuario = usuarioService.login(credenciales.get("email"), credenciales.get("contraseña"));
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{idUsuario}/skills")
    public ResponseEntity<Set<Skill>> obtenerSkillsDeUsuario(@PathVariable int idUsuario) {
        Set<Skill> skills = usuarioService.obtenerSkillsDeUsuario(idUsuario);
        if (skills != null && !skills.isEmpty()) {
            return new ResponseEntity<>(skills, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
