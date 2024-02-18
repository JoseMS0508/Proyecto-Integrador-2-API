package com.example.demo.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProyecto;

    @ManyToOne
    @JoinColumn(name = "id_usuario_creador")
    private Usuario usuarioCreador;

    private String nombreDescripcion;
    private String presencialidad;
    private String ubicacion;
    private String puestosQueNecesita;

    @ManyToMany
    @JoinTable(
            name = "proyecto_skills",
            joinColumns = @JoinColumn(name = "id_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "id_skill")
    )
    private Set<Skill> skillsSolicitadas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "inscripciones_proyecto",
            joinColumns = @JoinColumn(name = "id_proyecto"),
            inverseJoinColumns = @JoinColumn(name = "id_usuario")
    )
    @JsonIgnore
    private Set<Usuario> usuariosInscritos = new HashSet<>();

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public String getNombreDescripcion() {
        return nombreDescripcion;
    }

    public void setNombreDescripcion(String nombreDescripcion) {
        this.nombreDescripcion = nombreDescripcion;
    }

    public String getPresencialidad() {
        return presencialidad;
    }

    public void setPresencialidad(String presencialidad) {
        this.presencialidad = presencialidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getPuestosQueNecesita() {
        return puestosQueNecesita;
    }

    public void setPuestosQueNecesita(String puestosQueNecesita) {
        this.puestosQueNecesita = puestosQueNecesita;
    }

    public Set<Skill> getSkillsSolicitadas() {
        return skillsSolicitadas;
    }

    public void setSkillsSolicitadas(Set<Skill> skillsSolicitadas) {
        this.skillsSolicitadas = skillsSolicitadas;
    }

    public Set<Usuario> getUsuariosInscritos() {
        return usuariosInscritos;
    }

    public void setUsuariosInscritos(Set<Usuario> usuariosInscritos) {
        this.usuariosInscritos = usuariosInscritos;
    }
}
