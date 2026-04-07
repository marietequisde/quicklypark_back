package com.quicklypark.back.acceso.exception;

import com.quicklypark.back.util.Cadenas;

public class AutenticacionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutenticacionException() {
		super(Cadenas.ERROR_AUTENTICACION);
	}
}
