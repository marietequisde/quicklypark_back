package com.quicklypark.back.acceso.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gestor {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private @Nullable Long id;

	private String email;

	private String clave;

	private String nombre;

	private String apellidos;

	public Gestor(Long id, String email, String clave, String nombre, String apellidos) {
		super();
		this.id = id;
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Gestor(String email, String clave, String nombre, String apellidos) {
		super();
		this.email = email;
		this.clave = clave;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Gestor() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

}
