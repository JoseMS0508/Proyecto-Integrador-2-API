package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProyecto;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuarioCreador;

	private String nombreDescripcion;
	private String presencialidad;
	private String ubicacion;
	private String puestosQueNecesita;
	private String skillsDelPuestoSolicitado;
	
	@OneToMany(mappedBy = "proyecto")
    private Set<UsuarioInscribeEnProyecto> usuariosInscritos = new HashSet<>();
	
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
	public String getSkillsDelPuestoSolicitado() {
		return skillsDelPuestoSolicitado;
	}
	public void setSkillsDelPuestoSolicitado(String skillsDelPuestoSolicitado) {
		this.skillsDelPuestoSolicitado = skillsDelPuestoSolicitado;
	}

}
