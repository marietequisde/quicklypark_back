package com.quicklypark.back.acceso.entity;

import java.sql.Timestamp;
import org.hibernate.annotations.Immutable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(name = "vista_registro")
public class RegistroVistaEntity {

	@Id
	private Long id;

	private String tipoVehiculo;

	private Timestamp marcaTiempoEntrada;

	private Timestamp marcaTiempoSalida;

	private long idParking;

	public RegistroVistaEntity(Long id, String tipoVehiculo, Timestamp marcaTiempoEntrada, Timestamp marcaTiempoSalida,
			long idParking) {
		super();
		this.id = id;
		this.tipoVehiculo = tipoVehiculo;
		this.marcaTiempoEntrada = marcaTiempoEntrada;
		this.marcaTiempoSalida = marcaTiempoSalida;
		this.idParking = idParking;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistroVistaEntity() {
		super();
	}

	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
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

	public long getIdParking() {
		return idParking;
	}

	public void setIdParking(long idParking) {
		this.idParking = idParking;
	}

}
