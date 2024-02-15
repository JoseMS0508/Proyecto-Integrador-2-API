package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Usuario;
import com.example.demo.service.UsuarioService;

import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/api/usuarios") // Ajusta la ruta según tu estructura de API
public class ControladorUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String verificarConexion() {
        return "Conexión hecha";
    }
    
    // Endpoint para crear un nuevo usuario
    @PostMapping("/guardar")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioGuardado = usuarioService.guardarOActualizarUsuario(usuario);
        return ResponseEntity.ok(Map.of("mensaje", "Usuario creado con éxito", "id", usuarioGuardado.getId_usuario()));
    }

    // Endpoint para obtener todos los usuarios
    @GetMapping("/todos")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    // Puedes añadir más endpoints aquí según necesites
}
