package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Perdida extends Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Perdida() {
		this.nombre = "Perdida";
	}

}
