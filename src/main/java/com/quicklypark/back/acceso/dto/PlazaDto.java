package com.quicklypark.back.acceso.dto;

public class PlazaDto {

	private boolean libre;

	public PlazaDto(boolean libre) {
		super();
		this.libre = libre;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

}
