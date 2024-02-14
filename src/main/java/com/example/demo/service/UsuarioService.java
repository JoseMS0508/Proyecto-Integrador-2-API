package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios;
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario guardarOActualizarUsuario(Usuario usuario) {
        // Aquí simplemente guardamos o actualizamos el usuario sin encriptar la contraseña
        return usuarioRepository.save(usuario);
    }
    
    public boolean verificarCredenciales(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            // Compara directamente la contraseña en texto plano
            return usuario.getContraseña().equals(password);
        }
        return false;
    }

    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }

    // Puedes añadir más métodos aquí según necesites
}
