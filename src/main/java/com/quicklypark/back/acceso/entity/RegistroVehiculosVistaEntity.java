package com.quicklypark.back.acceso.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "vista_registro_vehiculos")
public class RegistroVehiculosVistaEntity {

	@Id
	private Long idParking;

	private int furgoneta;
	private int motocicleta;
	private int turismo;

	public RegistroVehiculosVistaEntity(Long idParking, int furgoneta, int motocicleta, int turismo) {
		super();
		this.idParking = idParking;
		this.furgoneta = furgoneta;
		this.motocicleta = motocicleta;
		this.turismo = turismo;
	}

	public RegistroVehiculosVistaEntity() {
		super();
	}

	public Long getIdParking() {
		return idParking;
	}

	public void setIdParking(Long idParking) {
		this.idParking = idParking;
	}

	public int getFurgoneta() {
		return furgoneta;
	}

	public void setFurgoneta(int furgoneta) {
		this.furgoneta = furgoneta;
	}

	public int getMotocicleta() {
		return motocicleta;
	}

	public void setMotocicleta(int motocicleta) {
		this.motocicleta = motocicleta;
	}

	public int getTurismo() {
		return turismo;
	}

	public void setTurismo(int turismo) {
		this.turismo = turismo;
	}

}
