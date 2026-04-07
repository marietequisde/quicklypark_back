package com.quicklypark.back.acceso.dto;

public class PlazaDto {

	private boolean libre;

	private Long id;

	public PlazaDto(Long id, boolean libre) {
		super();
		this.id = id;
		this.libre = libre;
	}

	public Long getIdPlaza() {
		return id;
	}

	public void setIdPlaza(Long id) {
		this.id = id;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

}
