package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioHabilidadId implements Serializable {
	
	private int id_usuario;
	private String habilidad;
	
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(String habilidad) {
		this.habilidad = habilidad;
	}

}
