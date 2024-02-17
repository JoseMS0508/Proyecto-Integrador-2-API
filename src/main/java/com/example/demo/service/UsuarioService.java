package com.example.demo.service;

import com.example.demo.models.Skill;
import com.example.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;

import java.util.Set;
import java.util.stream.Collectors;

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

        // Copiar propiedades de `usuario` a `usuarioExistente`, excepto id
        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setApellido1(usuario.getApellido1());
        usuarioExistente.setApellido2(usuario.getApellido2());
        usuarioExistente.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarioExistente.setEstudio(usuario.getEstudio());
        usuarioExistente.setNumTelefono(usuario.getNumTelefono());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setContraseña(usuario.getContraseña());

        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario buscarPorId(int id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public Usuario modificarHabilidadesUsuario(int idUsuario, Set<Skill> nuevasHabilidades) {
        // Buscar el usuario por ID
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + idUsuario));

        // Limpia las habilidades existentes y añade las nuevas
        // Esto reemplaza todas las habilidades existentes por las nuevas proporcionadas
        usuario.getSkills().clear();
        usuario.getSkills().addAll(nuevasHabilidades);

        // Guardar el usuario actualizado en la base de datos
        return usuarioRepository.save(usuario);
    }
    public void actualizarHabilidadesUsuario(int usuarioId, Set<Integer> idsHabilidades) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con el ID: " + usuarioId));

        Set<Skill> nuevasHabilidades = idsHabilidades.stream()
                .map(id -> skillRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Habilidad no encontrada con el ID: " + id)))
                .collect(Collectors.toSet());

        usuario.setSkills(nuevasHabilidades);
        usuarioRepository.save(usuario);
    }
}
