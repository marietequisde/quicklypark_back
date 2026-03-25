package com.quicklypark.back.acceso.dto;

public class RespuestaDto {

	private boolean exito;

	private String mensaje;

	public RespuestaDto(boolean exito, String mensaje) {
		super();
		this.exito = exito;
		this.mensaje = mensaje;
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
