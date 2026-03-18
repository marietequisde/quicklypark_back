package com.quicklypark.back.acceso.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "parking")
public class ParkingEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Nullable Long id;

	private String direccion;

	private String horario;

	public ParkingEntity(String direccion, String horario) {
		super();
		this.direccion = direccion;
		this.horario = horario;
	}

	public ParkingEntity(Long id, String direccion, String horario) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.horario = horario;
	}

	public ParkingEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
