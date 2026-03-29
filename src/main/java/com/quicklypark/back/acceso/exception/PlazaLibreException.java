package com.quicklypark.back.acceso.exception;

import com.quicklypark.back.util.Cadenas;

public class PlazaLibreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlazaLibreException() {
		super(Cadenas.ERROR_PLAZA_LIBRE);
	}
}
