package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    // Aquí puedes añadir métodos personalizados si es necesario,
    // por ejemplo, buscar proyectos por nombre, usuario creador, etc.
}
