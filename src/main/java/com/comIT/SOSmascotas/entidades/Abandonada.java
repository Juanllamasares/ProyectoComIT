package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Abandonada extends Estado implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public Abandonada() {
		this.nombre = "Abandonada";
	}

}
