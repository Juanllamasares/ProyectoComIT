package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
@Data
@Entity

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String correo,contraseña;
	@OneToMany
	private List <Reporte> reportes;
	
	public Usuario(String correo, String contraseña) {
		this.correo = correo;
		this.contraseña = contraseña;
	}
	

}
