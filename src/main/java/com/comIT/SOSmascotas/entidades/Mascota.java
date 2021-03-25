package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Type;

import lombok.Data;
@Data
@Entity

public class Mascota implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String ubicacion;
	@Type(type = "text")
	private String descripcion;
	@OneToMany
	private List <Foto> fotos;

}
