package com.quicklypark.back.acceso.entity;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "vista_registro_semanal")
public class RegistroSemanalVistaEntity {

	@Id
	private Long idParking;

	private int lunes;
	private int martes;
	private int miercoles;
	private int jueves;
	private int viernes;
	private int sabado;
	private int domingo;

	public RegistroSemanalVistaEntity(Long idParking, int lunes, int martes, int miercoles, int jueves, int viernes,
			int sabado, int domingo) {
		super();
		this.idParking = idParking;
		this.lunes = lunes;
		this.martes = martes;
		this.miercoles = miercoles;
		this.jueves = jueves;
		this.viernes = viernes;
		this.sabado = sabado;
		this.domingo = domingo;
	}

	public RegistroSemanalVistaEntity() {
		super();
	}

	public Long getId_parking() {
		return idParking;
	}

	public void setId_parking(Long idParking) {
		this.idParking = idParking;
	}

	public int getLunes() {
		return lunes;
	}

	public void setLunes(int lunes) {
		this.lunes = lunes;
	}

	public int getMartes() {
		return martes;
	}

	public void setMartes(int martes) {
		this.martes = martes;
	}

	public int getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(int miercoles) {
		this.miercoles = miercoles;
	}

	public int getJueves() {
		return jueves;
	}

	public void setJueves(int jueves) {
		this.jueves = jueves;
	}

	public int getViernes() {
		return viernes;
	}

	public void setViernes(int viernes) {
		this.viernes = viernes;
	}

	public int getSabado() {
		return sabado;
	}

	public void setSabado(int sabado) {
		this.sabado = sabado;
	}

	public int getDomingo() {
		return domingo;
	}

	public void setDomingo(int domingo) {
		this.domingo = domingo;
	}

}
