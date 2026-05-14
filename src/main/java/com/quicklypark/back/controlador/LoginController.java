package com.quicklypark.back.controlador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quicklypark.back.acceso.exception.AutenticacionException;
import com.quicklypark.back.util.Cadenas;
import com.quicklypark.back.util.SeguridadUtil;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SeguridadUtil seguridadUtil;

	@GetMapping
	@Operation(summary = "Ocupar una plaza por id")
	public ResponseEntity<?> login(@RequestParam String email, @RequestParam String clave) {
		try {
			seguridadUtil.validarCredenciales(email, clave);

		} catch (AutenticacionException e) {
			logger.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
		}

		return ResponseEntity.ok(Cadenas.EXITO_AUTENTICACION);
	}
}
