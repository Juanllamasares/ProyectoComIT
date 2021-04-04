package com.comIT.SOSmascotas.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class Foto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String foto;

}
