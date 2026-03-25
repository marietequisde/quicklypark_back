package com.quicklypark.back.acceso.dto;

public class PlazaDto {

	private boolean libre;

	private long id;

	public PlazaDto(long id, boolean libre) {
		super();
		this.id = id;
		this.libre = libre;
	}

	public long getIdPlaza() {
		return id;
	}

	public void setIdPlaza(long id) {
		this.id = id;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

}
