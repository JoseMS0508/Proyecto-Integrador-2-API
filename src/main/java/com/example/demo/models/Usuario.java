package com.example.demo.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import java.util.Date;


@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    
    private String estudio; 
    
    
	@OneToMany(mappedBy = "usuario")
    private Set<UsuarioTieneHabilidad> usuarioHabilidades = new HashSet<>();
    
    private String numTelefono;
    private String email;
    private String contraseña;
    
    @OneToMany(mappedBy = "usuarioCreador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Proyecto> proyectosCreados = new HashSet<>();
    
    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioInscribeEnProyecto> proyectosInscritos = new HashSet<>();
    
    // Getters y setters

    public int getId() {
        return id_usuario;
    }
    public void setId(int id) {
        this.id_usuario = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getEstudio() {
        return estudio;
    }
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    public String getNumTelefono() {
        return numTelefono;
    }
    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }
   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Set<UsuarioTieneHabilidad> getUsuarioHabilidades() {
		return usuarioHabilidades;
	}
	public void setUsuarioHabilidades(Set<UsuarioTieneHabilidad> usuarioHabilidades) {
		this.usuarioHabilidades = usuarioHabilidades;
	}
}
