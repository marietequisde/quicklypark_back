package com.quicklypark.back.acceso.entity;

import java.sql.Timestamp;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "registro")
public class RegistroEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Nullable Long id;

	private String matricula;

	private Long idTipoVehiculo;

	@Column(insertable = false)
	private Timestamp marcaTiempoEntrada;

	private Timestamp marcaTiempoSalida;

	private long idPlaza;

	public RegistroEntity(Long id, String matricula, Long idTipoVehiculo, Timestamp marcaTiempoEntrada,
			Timestamp marcaTiempoSalida, long idPlaza) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.idTipoVehiculo = idTipoVehiculo;
		this.marcaTiempoEntrada = marcaTiempoEntrada;
		this.marcaTiempoSalida = marcaTiempoSalida;
		this.idPlaza = idPlaza;
	}

	public RegistroEntity(String matricula, Long idTipoVehiculo, Timestamp marcaTiempoEntrada,
			Timestamp marcaTiempoSalida, long idPlaza) {
		super();
		this.matricula = matricula;
		this.idTipoVehiculo = idTipoVehiculo;
		this.marcaTiempoEntrada = marcaTiempoEntrada;
		this.marcaTiempoSalida = marcaTiempoSalida;
		this.idPlaza = idPlaza;
	}

	public RegistroEntity(String matricula, Long idTipoVehiculo, long idPlaza) {
		super();
		this.matricula = matricula;
		this.idTipoVehiculo = idTipoVehiculo;
		this.idPlaza = idPlaza;
	}

	public RegistroEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Timestamp getMarcaTiempoEntrada() {
		return marcaTiempoEntrada;
	}

	public void setMarcaTiempoEntrada(Timestamp marcaTiempoEntrada) {
		this.marcaTiempoEntrada = marcaTiempoEntrada;
	}

	public Timestamp getMarcaTiempoSalida() {
		return marcaTiempoSalida;
	}

	public void setMarcaTiempoSalida(Timestamp marcaTiempoSalida) {
		this.marcaTiempoSalida = marcaTiempoSalida;
	}

	public long getIdPlaza() {
		return idPlaza;
	}

	public void setIdPlaza(long idPlaza) {
		this.idPlaza = idPlaza;
	}

	public Long getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}

}
