package com.quicklypark.back.acceso.exception;

import com.quicklypark.back.util.Cadenas;

public class PlazaOcupadaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlazaOcupadaException() {
		super(Cadenas.ERROR_PLAZA_OCUPADA);
	}
}
