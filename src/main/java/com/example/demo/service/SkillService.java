package com.example.demo.service;

import java.util.List;
import com.example.demo.models.Skill;
import com.example.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    // Añadir una nueva habilidad
    public Skill añadirSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // Eliminar una habilidad por ID
    public void eliminarSkill(int id) {
        skillRepository.deleteById(id);
    }

    // Modificar una habilidad existente
    public Skill modificarSkill(int id, Skill skillDetalles) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill no encontrada con el ID: " + id));
        
        skill.setNombre(skillDetalles.getNombre());
        // Aquí se pueden añadir más campos si la entidad Skill tiene más información que actualizar
        
        return skillRepository.save(skill);
    }

    // Buscar una habilidad por ID
    public Skill buscarPorId(int id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill no encontrada con el ID: " + id));
    }

    // Listar todas las habilidades
    public List<Skill> listarSkills() {
        return skillRepository.findAll();
    }
}
