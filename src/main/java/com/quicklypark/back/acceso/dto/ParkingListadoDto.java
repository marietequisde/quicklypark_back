package com.quicklypark.back.acceso.dto;

public class ParkingListadoDto {

	private long id;

	private String direccion;

	private String horario;

	public ParkingListadoDto() {
		super();
	}

	public ParkingListadoDto(long id, String direccion, String horario) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.horario = horario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

}
