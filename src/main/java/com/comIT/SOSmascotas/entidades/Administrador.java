package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
public class Administrador extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
}
