package com.example.demo.service;

import com.example.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SkillRepository skillRepository;

    public Usuario crearUsuario(Usuario usuario) {
        // Aquí podrías manejar lógica como verificar si el usuario ya existe, etc.
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario modificarUsuario(int id, Usuario usuario) {
        // Asegurarse de que el usuario existe
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        // Aquí copiarías las propiedades de `usuario` a `usuarioExistente`, excepto id
        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
