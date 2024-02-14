package com.example.demo.models;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioProyectoId implements Serializable  {

	private int idUsuario;
    private int idProyecto;
}
