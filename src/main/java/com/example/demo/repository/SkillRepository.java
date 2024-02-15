package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {
    // Opcional: Añadir métodos para buscar habilidades por nombre u otros criterios
}