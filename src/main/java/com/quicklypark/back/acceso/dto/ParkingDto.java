package com.quicklypark.back.acceso.dto;

public class ParkingDto {
	private String direccion;

	private String horario;

	private PlazaDto[][] plazas;

	public ParkingDto() {
		super();
	}

	public ParkingDto(String direccion, String horario, PlazaDto[][] plazas) {
		super();
		this.direccion = direccion;
		this.horario = horario;
		this.plazas = plazas;
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

	public PlazaDto[][] getPlazas() {
		return plazas;
	}

	public void setPlazas(PlazaDto[][] plazas) {
		this.plazas = plazas;
	}

}
