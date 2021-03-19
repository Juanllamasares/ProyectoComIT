package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Data
@Entity

public class Mascota implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String descripcion,ubicacion;
	@OneToMany
	private List <Foto> fotos;

}
