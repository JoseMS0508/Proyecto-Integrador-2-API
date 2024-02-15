package com.example.demo.controller;

import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios") // Ajusta la ruta según tu estructura de API
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
}
