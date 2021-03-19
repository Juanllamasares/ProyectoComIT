package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
@Data
@Entity

public class Reporte implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Integer fechaCreacion;
	private Boolean baja;
	@OneToOne
	private Estado estado;
	private Mascota mascota;
	@OneToMany
	private List <Contacto> contactos;

}
