package com.quicklypark.back.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quicklypark.back.acceso.exception.AutenticacionException;
import com.quicklypark.back.acceso.repository.GestorRepository;

@Component
public class SeguridadUtil {

	@Autowired
	private GestorRepository gestorRepository;

	public void validarCredenciales(String email, String clave) throws AutenticacionException {
		gestorRepository.obtenerPorEmailYClave(email, clave).orElseThrow(() -> new AutenticacionException());
	}
}
