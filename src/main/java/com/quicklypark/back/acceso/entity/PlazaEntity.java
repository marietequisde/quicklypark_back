package com.quicklypark.back.acceso.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plaza")
public class PlazaEntity {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private @Nullable Long id;

	private int planta;
	
	private int fila;
	
	private int columna;
	
	private long idParking;
	
	private boolean libre;

	public PlazaEntity(Long id, int planta, int fila, int columna, long idParking, boolean libre) {
		super();
		this.id = id;
		this.planta = planta;
		this.fila = fila;
		this.columna = columna;
		this.idParking = idParking;
		this.libre = libre;
	}

	public PlazaEntity(int planta, int fila, int columna, long idParking, boolean libre) {
		super();
		this.planta = planta;
		this.fila = fila;
		this.columna = columna;
		this.idParking = idParking;
		this.libre = libre;
	}

	public PlazaEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public long getIdParking() {
		return idParking;
	}

	public void setIdParking(long idParking) {
		this.idParking = idParking;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	
}
