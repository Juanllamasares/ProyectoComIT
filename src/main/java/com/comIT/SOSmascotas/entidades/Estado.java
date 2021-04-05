package com.comIT.SOSmascotas.entidades;

enum Estado {

	PERDIDA("Perdida"), ABANDONADA("Abandonada"), EN_TRANSITO("En Tránsito"), EN_ADOPCION("En Adopción");

	private String descripcion;

	private Estado(String descrip) {
		this.descripcion = descrip;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
