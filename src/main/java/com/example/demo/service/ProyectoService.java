package com.example.demo.service;

import java.util.List;
import com.example.demo.models.Proyecto;
import com.example.demo.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.Usuario;
import com.example.demo.repository.UsuarioRepository;
@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Proyecto crearProyecto(Proyecto proyecto) {
        // Verificar usuario creador y skills si necesario
        return proyectoRepository.save(proyecto);
    }

    public Proyecto editarProyecto(int id, Proyecto proyecto) {
        // Asegurarse de que el proyecto existe y manejar la lógica para editar
        Proyecto proyectoExistente = proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        // Copiar propiedades relevantes de `proyecto` a `proyectoExistente`
        return proyectoRepository.save(proyectoExistente);
    }

    public void borrarProyecto(int id) {
        proyectoRepository.deleteById(id);
    }

    public Proyecto buscarPorId(int id) {
        return proyectoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
    }

    public List<Proyecto> buscarTodos() {
        return proyectoRepository.findAll();
    }

    public void inscribirUsuario(int proyectoId, int usuarioId) {
        Proyecto proyecto = buscarPorId(proyectoId);
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        proyecto.getUsuariosInscritos().add(usuario);
        proyectoRepository.save(proyecto);
    }

    public void desinscribirUsuario(int proyectoId, int usuarioId) {
        Proyecto proyecto = buscarPorId(proyectoId);
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        proyecto.getUsuariosInscritos().remove(usuario);
        proyectoRepository.save(proyecto);
    }
}
